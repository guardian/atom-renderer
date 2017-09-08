name := "atom-renderer"
organization := "com.gu"
version := "0.1"
scalacOptions ++= Seq("-feature", "-deprecation", "-target:jvm-1.8")
scalaVersion := "2.11.11"

val circeVersion = "0.8.0"

libraryDependencies ++= Seq(
  "com.gu"   %% "content-atom-model" % "2.4.47",
  "com.gu"   %% "fezziwig"           % "0.4",
  "io.circe" %% "circe-core"         % circeVersion,
  "io.circe" %% "circe-generic"      % circeVersion,
  "io.circe" %% "circe-parser"       % circeVersion
)

TwirlKeys.templateFormats += ("css" -> "com.gu.contentatom.renderer.twirl.CssFormat")

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

sourceDirectories in (Compile, TwirlKeys.compileTemplates) += (resourceDirectory in Compile).value

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
resolveFromWebjarsNodeModulesDir := true

resolvers += Resolver.bintrayRepo("webjars","maven")
