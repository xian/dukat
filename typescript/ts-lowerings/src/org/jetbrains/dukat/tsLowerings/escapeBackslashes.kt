package org.jetbrains.dukat.tsLowerings

import org.jetbrains.dukat.tsmodel.SourceSetDeclaration
import org.jetbrains.dukat.tsmodel.expression.literal.StringLiteralExpressionDeclaration

private class EscapeLiteralsLowering : DeclarationLowering {
    override fun lowerStringLiteralDeclaration(literal: StringLiteralExpressionDeclaration): StringLiteralExpressionDeclaration {
        return literal.copy(
            value = literal.value.replace("\n", "\\n")
        )
    }
}

class EscapeLiterals : TsLowering {
    override fun lower(source: SourceSetDeclaration): SourceSetDeclaration {
        return source.copy(sources = source.sources.map { sourceFileDeclaration ->
            sourceFileDeclaration.copy(root = EscapeLiteralsLowering().lowerSourceDeclaration(sourceFileDeclaration.root))
        })
    }
}