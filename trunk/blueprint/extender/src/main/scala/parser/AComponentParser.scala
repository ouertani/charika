package net.dikka.charika.blueprint
package parser


import scala.xml.Node

abstract class AComponentParser [T] {
  def  parseElement( node:Node):T
}