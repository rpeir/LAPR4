#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies

export ECOURSE_CP=ecourse.app.sharedboard.tcp.server/target/tcp.server-1.0.0.jar:ecourse.app.sharedboard.tcp.server/target/dependency/*;

#REM call the java VM, e.g,
java -cp $ECOURSE_CP eapli.ecourse.tcp.server.TcpSharedBoardServerApp
