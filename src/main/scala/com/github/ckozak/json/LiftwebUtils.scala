package com.github.ckozak.json

object LiftwebUtils {
  import net.liftweb.json._

  implicit val formats = Serialization.formats(NoTypeHints)
}
