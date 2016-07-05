> import scala.meta._
> """ object Main extends App { self =>
        println(s"Hello $self!") // This is a comment
      }""".parse[Source].get.structure // comment
res0: String = """
Source(Seq(Defn.Object(Nil, Term.Name("Main"), Template(Nil, Seq(Ctor.Ref.Name("App")), Term.Param(Nil, Term.Name("self"), None, None), Some(Seq(Term.Apply(Term.Name("println"), Seq(Term.Interpolate(Term.Name("s"), Seq(Lit("Hello "), Lit("!")), Seq(Term.Name("self")))))))))))
"""
