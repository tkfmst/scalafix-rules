package fix

import scalafix.v1._
import scala.meta._

class UseAsteriskForWildcardImport
    extends SyntacticRule("UseAsteriskForWildcardImport") {

  override def fix(implicit doc: SyntacticDocument): Patch = {
    doc.tree.collect {
      case t: Importee.Wildcard if t.toString == "_" =>
        Patch.replaceTree(t, "*")
    }.asPatch
  }
}
