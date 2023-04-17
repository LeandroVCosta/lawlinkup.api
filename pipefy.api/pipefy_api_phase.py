import requests
import sqlalchemy

PERGUNTAS = ['Digite seu nome','Insira seu telefone ','Digite o seu e-mail',
            'Advogado ou cliente?', 'Por onde você nos conheceu?',
            'Deseja ser notificado por e-mail quando houverem novidades e promoções?']

PERGUNTAS_CLIENTE = ['Você tem um imóvel próprio?', 'Com qual frequência você procura por advogados quando precisa assinar algum contrato?']
PERGUNTAS_ADVOGADO = ['Quais são as suas especificações?','Em qual(is) dessa(s) situação(ões) abaixo você se encontra?']

CURSOR = {"visitante":"WyIzLjg3NSIsIjEuMCIsNjc0Mjc4MzQ1XQ",
          "lead":"WyIzLjg3NSIsIjMuMCIsNjc0Mjg2MDM1XQ",
          "oportunidade":"WyI1LjI1IiwiMTYuMCIsNjc0MzI4Mjk5XQ",
          "cliente":"WyI1LjI1IiwiMTcuMCIsNjc0MzI4NzM2XQ"}

def create_db_connection():
    conn = sqlalchemy.create_engine('mysql+pymysql://root:root@localhost/teste')
    return conn

def get_report_value(fields: list[dict], perguntas) -> dict:
    respostas = {}
    for r in fields:
        if r["name"] in perguntas:
            respostas[r["name"]] = r["report_value"]
    return respostas
        

def query_by_phase(phase):

    if phase == 'visitante':
        phase_end = CURSOR["visitante"]
        arguments = ", before:\"" + phase_end  + "\""
        print("querying visitante")

    if phase == 'lead':
        phase_start = CURSOR["visitante"]
        phase_end = CURSOR["lead"]
        arguments = f", after:\"" + phase_start  + "\""
        arguments += ", before:\"" + phase_end  + "\""
        print("querying lead")
    
    if phase == 'oportunidade':
        phase_start = CURSOR["lead"]
        phase_end = CURSOR["oportunidade"]
        arguments = ", after:\"" + phase_start  + "\""
        arguments += ", before:\"" + phase_end  + "\""
        print("querying oportunity")
    
    if phase == 'cliente':
        phase_start = CURSOR["cliente"]
        arguments = ", after:\"" + phase_start  + "\""
        print("querying client")

    url = "https://api.pipefy.com/graphql" 
    payload = {"query":"{allCards(pipeId: 303161177 " + arguments +") {pageInfo { startCursor endCursor }      edges  {  node {         id         title         fields {           name           report_value       }       }     }   } }"}
    headers = { 
        "accept": "application/json",
        "content-type": "application/json",
        "authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyIjp7ImlkIjozMDIwOTUwODQsImVtYWlsIjoibGVhbmRyby5jb3N0YUBzcHRlY2guc2Nob29sIiwiYXBwbGljYXRpb24iOjMwMDI0MjI1MH19.dzpD0D_0woLElzhut2NlF1fZLin6FAGQL816-WnIcSWe4jtcQIGzjfAl2tvkZ7HTr1ZGNXcldsuk6B2FxD8IHQ"
    }
    response = requests.post(url, json=payload, headers=headers).json()
    return response


conn = create_db_connection()

for i in CURSOR:
    values = []
    phase = str(i)
    phase_id = CURSOR[i]
    response = query_by_phase(phase)
    d = response["data"]["allCards"]["edges"]
    for i in d:
        card = i["node"]["fields"] 
        id = int(i["node"]["id"])
        respostas = sorted(get_report_value(card, PERGUNTAS).values())
        columns = ['telefone','tipo','nome','fonte','ativo','email','p1','p2','card_id','fase']
        if respostas[1] == 'Cliente':
            main_quests = get_report_value(card,PERGUNTAS_CLIENTE)
        else:
            main_quests = get_report_value(card,PERGUNTAS_ADVOGADO)
        main_quest = sorted(main_quests.values())
        for i in main_quest:
            respostas.append(i)
        respostas.append(id)
        respostas.append(phase)
        column_str = ''
        for i in columns:
            column_str += i + ', '
        column_str = column_str[0:len(column_str)-2]
        for i in range(len(respostas)):
            if respostas[i] == 'Sim':
                respostas[i] = 1
                print('a')
            if respostas[i] == 'Não':
                respostas[i] = 0
            
        print(respostas)   
        stmt = f'INSERT INTO clientespipefy({column_str})' + 'values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'
        print(respostas)
        conn.execute(stmt, respostas)

