import sbt.util

name := "sketches-scala"

version := "0.1"

scalaVersion := "3.1.3"
logLevel := util.Level.Debug

resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.micycle1" % "processing-core-4" % "4.0b8"