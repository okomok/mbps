

package okomok.mbps.makro


import scala.language.experimental.macros
import scala.reflect.macros.Context


object Summary {
     def apply[x](x: x) = macro impl[x]

     def impl[x](c: Context)(x: c.Expr[x])(implicit tx: c.WeakTypeTag[x]): c.Expr[x] = {
         import c.universe._

         assert {
             val tr: c.Tree = x.tree
             x == c.Expr[x](tr)
         }

         val _x: c.Type = tx.tpe

         assert {
             tx == c.WeakTypeTag[x](_x)
         }

         assert {
             _x =:= TypeTree(_x).tpe
         }

         locally {
             val tr: c.Tree = Literal(Constant(1))
             val Literal(Constant(1)) = tr
         }

         locally {
             val tr: c.Tree = q"1"
             val q"${i}" = tr
             val Literal(Constant(1)) = i
         }

         locally {
            val tr: c.Tree = tq"Int"
            val tq"${i}" = tr
            val Ident(TypeName("Int")) = i
         }

         locally {
             val tr: c.Tree = c.parse("1")
             val Literal(Constant(1)) = tr
         }

         locally {
             val tr = reify(1)
             val Literal(Constant(1)) = reify{ tr.splice }.tree
         }

         locally {
             val i = c.eval(c.literal(3))
             println(i)
         }

         x
     }
}