#!/usr/bin/env bash
echo off
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH
mvn -B dependency:copy-dependencies verify -D maven.javadoc.skip=true -Dmaven.test.skip=true
