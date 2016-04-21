class ResolutionCopier {
  @override
  bool visitClassDeclaration(ClassDeclaration node) {
    ClassDeclaration toNode = this._toNode as ClassDeclaration;
    return javaBooleanAnd( javaBooleanAnd( javaBooleanAnd( javaBooleanAnd(javaBooleanAnd(javaBooleanAnd( javaBooleanAnd(javaBooleanAnd( javaBooleanAnd(javaBooleanAnd(javaBooleanAnd( _isEqualNodes(node.documentationComment, toNode.documentationComment), _isEqualNodeLists( node.metadata, toNode.metadata)), _isEqualTokens(node.abstractKeyword, toNode.abstractKeyword)), _isEqualTokens( node.classKeyword, toNode.classKeyword)), _isEqualNodes( node.name, toNode.name)), _isEqualNodes( node.typeParameters, toNode.typeParameters)), _isEqualNodes( node.extendsClause, toNode.extendsClause)), _isEqualNodes( node.withClause, toNode.withClause)), _isEqualNodes( node.implementsClause, toNode.implementsClause)), _isEqualTokens(node.leftBracket, toNode.leftBracket)), _isEqualNodeLists( node.members, toNode.members)), _isEqualTokens( node.rightBracket,
            toNode.rightBracket));
  }
}
