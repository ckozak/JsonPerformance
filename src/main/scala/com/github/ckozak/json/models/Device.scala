package com.github.ckozak.json.models

case class Device(
  deviceId: String,
  lists: Seq[String],
  moreLists: Seq[String]
)
