const nodemailer=require("nodemailer")


const sendMail=async(email)=>{
    try{
        const transporter=nodemailer.createTransport({
        service:"gmail",
        host:"smtp.gmail.com",
        port:465,
        secure:false,
        auth:{
            user:"yourmailaddress",
            pass:"yourpassword",
        }
    })
    await transporter.sendMail({
        from:process.env,
        to:email,
        subject:"Hoşgeldiniz.",
        html:`<p>Hoşgeldiniz ${email}</a></p>`
    })
    }catch(error){
        console.log(error)
    }
}
module.exports=sendMail