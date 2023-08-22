const path = require('path')

const app = require('express')();

const http = require('http').Server(app);

var io = require('socket.io')(http);

app.get('/',function(req,res) {
    var options = {
        root: path.join(__dirname)
    }
    var filename = "index.html";
    res.sendFile(filename,options)
});

io.on('connection',function(socket){
    console.log('Um usuário foi conectado');
    console.log(`Socket id ${socket.id}`);
    socket.send('Olá');
    io.sockets.emit('broadcast',{message:'Um usuário acabou de se conectar!'});
    
    socket.on('disconnect',function(){
        console.log("Usuário Desconectado")
    });
});

http.listen(
    3000,function () {
        console.log("The server has started in port 3000");
    }
);