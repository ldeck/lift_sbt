name := "Lift 3.0 basic starter template"

version := "0.0.4"

organization := "net.liftweb"

scalaVersion := "2.11.7"

resolvers ++= Seq("snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
                  "staging"       at "https://oss.sonatype.org/content/repositories/staging",
                  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
                 )

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "3.0-M6"
  Seq(
    "net.liftweb"       %% "lift-webkit"            % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"            % liftVersion        % "compile",
    "net.liftmodules"   %% "lift-jquery-module_3.0" % "2.9"              % "compile",
    "ch.qos.logback"    % "logback-classic"         % "1.1.3",
    "org.specs2"        %% "specs2-core"            % "3.6.4"            % "test",
    "com.h2database"    % "h2"                      % "1.4.187",
    "javax.servlet"     % "javax.servlet-api"       % "3.1.0"            % "provided",
    "org.eclipse.jetty" % "jetty-webapp"            % "9.2.13.v20150730" % "jetty,test",
    "org.eclipse.jetty" % "jetty-plus"              % "9.2.13.v20150730" % "jetty,test" // For Jetty Config
  )
}

scalacOptions in Test ++= Seq("-Yrangepos")

enablePlugins(JettyPlugin)