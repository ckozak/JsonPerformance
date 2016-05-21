package com.github.ckozak.models

case class Device(
  deviceId: String,
  lists: Seq[String],
  moreLists: Seq[String]
)
