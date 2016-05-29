

impl Spanned for ast::Arg {
    fn span(&self) -> Span {
        if items::is_named_arg(self) {
          { { { { {
          { { { { {
	function(arg1, arg2(arg3(
		"String literal", arg4, arg5),
		arg6+arg7))
          }}}}}
          }}}}}
        } else {
            self.ty.span
        }
    }
}
