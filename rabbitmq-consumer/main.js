const rabbit = require('amqplib');
const sendMail=require("./sendMail")
const QUEUE_NAME = 'metsoft';
connection = rabbit.connect('amqp://localhost');
connection.then(async (conn)=>{
   const channel = await conn.createChannel();
   channel.consume(QUEUE_NAME, (m)=>{
        sendMail((m.content).toString())
        console.log("mail sended to "+(m.content).toString())
         channel.ack(m)
   })
})
