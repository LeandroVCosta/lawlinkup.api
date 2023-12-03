import sqlalchemy
import pandas as pd
from time import sleep

PRD_USER = "svc_dw_ingestion"
PRD_PASS = "p6vx3YdSZVMh9X"
PRD_HOST = "35.231.149.15"

DW_USER = "svc_dw_load"
DW_PASS = "4PDC8d9rvjUspd"
DW_HOST = "34.138.184.160"



TABLES = {
    "exportar_usuarios":["lawlinkup","usuario"],
    "exportar_casos":["lawlinkup","caso"],
    "exportar_pipefy":["pipefy","card"]
}

lawlinkup_conn = sqlalchemy.create_engine(f"mysql+pymysql://{PRD_USER}:{PRD_PASS}@{PRD_HOST}").connect()
dw_conn = sqlalchemy.create_engine(f"mysql+pymysql://{DW_USER}:{DW_PASS}@{DW_HOST}").connect()

for table in TABLES.keys():

    schema_name = TABLES[table][0]
    table_name = TABLES[table][1]
    prefix = "_data"

    values_to_replace = ["-"," ","+"]

    df = pd.read_sql_table(table,lawlinkup_conn,schema=TABLES[table][0])

    if table_name == "card":
        df['telefone'] = df['telefone'].apply(lambda x : str(x).strip())
        
        for value in values_to_replace:
            df['telefone'] = df['telefone'].apply(lambda x : str(x).replace(value,""))


    dw_conn.execute(sqlalchemy.text(f"truncate table {schema_name}{prefix}.{table_name};"))

    df.to_sql(table_name,con=dw_conn,schema=schema_name + prefix, if_exists='append',index=False)
    dw_conn.commit()








