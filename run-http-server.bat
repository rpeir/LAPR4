REM set the class path,
REM assumes the build was executed with maven copy-dependencies

SET ECOURSE_CP=ecourse.app.sharedboard.http.server/target/http.server-1.0.0.jar:ecourse.app.sharedboard.http.server/target/dependency/*;

REM call the java VM, e.g,
java -cp %ECOURSE_CP% eapli.ecourse.app.sharedBoard.HttpSharedBoardServerApp %1
