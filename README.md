<h1>QuizzPro_Project</h1> 
<discription>
This Project is whenever a user wants to log in to their QuizzPro account. Firstly, the user needs to enter their username and password. If the user's credentials are correct, then the user needs to verify the OTP sent to their respective email IDs.if the user failed to enter the otp within the time limit, then the user needs to click the resend button, which generates a new otp sent to their email. If successful, then only the user can see the QuizzPro Home page.</discription>


<h1>MYSQL</h1>
<p>Verion : 8.0.33</p>
<p>DataBase Name : quizzdb </p>
<P>Table name : myusers </P>
<p>Columns names : user_Id,full_Name,email,phone,password,top,status</p>
<p>Table Query : 
create table myusers (
	
user_Id int primary key,
full_Name char(20),
email char(30),
phone long,
password char(20),
otp int(9),
status char(15)
);
</p>

<h1>Java </h1>
<p>Verion : 1.8 </p>

<h1>Tools Used</h1>
<p>Eclipse : 2024-06 (4.32.0)</p>
<P>Git :  2.47.0</P>


