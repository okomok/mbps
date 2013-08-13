

package okomok.mbps.makro

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.{Context, TypecheckException}



object Material {
     def apply(x: Int) = macro term_impl

    def term_impl(c: Context)(x: c.Expr[Int]): c.Expr[Any] = {
        import c.universe._
        c.literal("hello")
    }
}



class typeIdentity extends StaticAnnotation {
    def macroTransform(annottees: Any*) = macro _typeIdentity.impl
}


object _typeIdentity extends TypeToTypeMacro1Impl {
    override protected def _apply(c: Context)(arg: c.Type): c.Type = {
        import c.universe._
        arg
    }
}