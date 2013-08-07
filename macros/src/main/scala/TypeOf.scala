

package okomok.mbps.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


import scala.language.experimental.macros
import scala.reflect.macros.Context


object TypeOf {
    type apply[x](x: x) = macro impl[x]

    def impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Tree = {
        import c.universe._
        TypeTree(tx.tpe)
    }
}