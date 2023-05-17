package fix

import scalafix.v1._
import scala.meta._

class UnifyNameOfUseCase extends SyntacticRule("UnifyNameOfUseCase") {

  override def fix(implicit doc: SyntacticDocument): Patch = {
    doc.tree
      .collect {
        case t @ Term.Name(name) if filter(t) => Patch.replaceTree(t, convert(name))
        case t @ Type.Name(name) => Patch.replaceTree(t, convert(name))
        case t @ Name.Indeterminate(value) => Patch.replaceTree(t, convert(value))
      }
      .asPatch
  }

  private def filter(t: Term): Boolean =
    t.parent match {
      case Some(_: Pkg.Object) => false
      case Some(_: Importer) => false
      case _ => true
    }

  private def convert(from: String): String = {
    val r1 = """^usecase(.*)$""".r
    val r2 = """^(.*)Usecase(.*)$""".r
    from match {
      case r1(tail)       => s"useCase${tail}"
      case r2(head, tail) => s"${head}UseCase${tail}"
      case _              => from
    }
  }
}
