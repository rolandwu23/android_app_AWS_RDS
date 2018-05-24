connect_android_to_AWS_RDS
android_app_AWS_RDS

This is a project for connecting android application directly to AWS RDS.
I feel like everything I've been doing is on local drive. And wanted to try sth new.

First, I host EC2 service and RDS service. And I put RDS on EC2 server by PHP.
Basically I used Json parsing to parse data between android and server. So I used PHP to encode database data into Json. 

You can see all the PHP under server folder.
In dbinfo.inc file, please be careful that you must put in endpoint:3306 for endpoint attribute.

If you want to test this project in your local drive, you can do so by chaning the URL.

For configuring AWS RDS and EC2 services, please follow the guideline in AWS. Just make sure that u made correct VPC and security group. 

Good luck and have fun!
