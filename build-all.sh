#!/usr/bin/env bash
echo off
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH
mvn $1 dependency:copy-dependencies package
