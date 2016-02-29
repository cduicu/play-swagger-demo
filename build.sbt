name := """swagger"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

//resolvers += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  cache,
  "com.iheart" %% "play-swagger" % "0.1.11",
  "org.webjars" % "swagger-ui" % "2.1.4"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
//routesGenerator := InjectedRoutesGenerator
