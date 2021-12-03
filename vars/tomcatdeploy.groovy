def call(cred_id,user,ip){
   sshagent(['cred_id']) {
        // rename the jAR file
        sh "mv target/*.jar target/HELLOFX.jar"
      // copy jar file to tomcat server
     sh "scp -o strictHostKeyChecking=no target/hellofx.jar ${user}@${ip}:/opt/tomcat8/webapps"
     //stop and start tomcat
     sh "ssh ${user}@${ip} /opt/tomcat8/bin/shutdown.sh"
     sh "ssh ${user}@${ip} /opt/tomcat8/bin/startup.sh"
                }
}
