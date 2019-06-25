// Generated from com\theoxao\antlr\source\Asyncript.g4 by ANTLR 4.6
package com.theoxao.base.script.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AsyncriptParser}.
 */
public interface AsyncriptListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link AsyncriptParser#compilationUnit}.
     *
     * @param ctx the parse tree
     */
    void enterCompilationUnit(AsyncriptParser.CompilationUnitContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#compilationUnit}.
     *
     * @param ctx the parse tree
     */
    void exitCompilationUnit(AsyncriptParser.CompilationUnitContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#packageDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterPackageDeclaration(AsyncriptParser.PackageDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#packageDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitPackageDeclaration(AsyncriptParser.PackageDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#importDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterImportDeclaration(AsyncriptParser.ImportDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#importDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitImportDeclaration(AsyncriptParser.ImportDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterTypeDeclaration(AsyncriptParser.TypeDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitTypeDeclaration(AsyncriptParser.TypeDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#modifier}.
     *
     * @param ctx the parse tree
     */
    void enterModifier(AsyncriptParser.ModifierContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#modifier}.
     *
     * @param ctx the parse tree
     */
    void exitModifier(AsyncriptParser.ModifierContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#classOrInterfaceModifier}.
     *
     * @param ctx the parse tree
     */
    void enterClassOrInterfaceModifier(AsyncriptParser.ClassOrInterfaceModifierContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#classOrInterfaceModifier}.
     *
     * @param ctx the parse tree
     */
    void exitClassOrInterfaceModifier(AsyncriptParser.ClassOrInterfaceModifierContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#variableModifier}.
     *
     * @param ctx the parse tree
     */
    void enterVariableModifier(AsyncriptParser.VariableModifierContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#variableModifier}.
     *
     * @param ctx the parse tree
     */
    void exitVariableModifier(AsyncriptParser.VariableModifierContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#classDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterClassDeclaration(AsyncriptParser.ClassDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#classDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitClassDeclaration(AsyncriptParser.ClassDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeParameters}.
     *
     * @param ctx the parse tree
     */
    void enterTypeParameters(AsyncriptParser.TypeParametersContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeParameters}.
     *
     * @param ctx the parse tree
     */
    void exitTypeParameters(AsyncriptParser.TypeParametersContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeParameter}.
     *
     * @param ctx the parse tree
     */
    void enterTypeParameter(AsyncriptParser.TypeParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeParameter}.
     *
     * @param ctx the parse tree
     */
    void exitTypeParameter(AsyncriptParser.TypeParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeBound}.
     *
     * @param ctx the parse tree
     */
    void enterTypeBound(AsyncriptParser.TypeBoundContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeBound}.
     *
     * @param ctx the parse tree
     */
    void exitTypeBound(AsyncriptParser.TypeBoundContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#enumDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterEnumDeclaration(AsyncriptParser.EnumDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#enumDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitEnumDeclaration(AsyncriptParser.EnumDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#enumConstants}.
     *
     * @param ctx the parse tree
     */
    void enterEnumConstants(AsyncriptParser.EnumConstantsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#enumConstants}.
     *
     * @param ctx the parse tree
     */
    void exitEnumConstants(AsyncriptParser.EnumConstantsContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#enumConstant}.
     *
     * @param ctx the parse tree
     */
    void enterEnumConstant(AsyncriptParser.EnumConstantContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#enumConstant}.
     *
     * @param ctx the parse tree
     */
    void exitEnumConstant(AsyncriptParser.EnumConstantContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#enumBodyDeclarations}.
     *
     * @param ctx the parse tree
     */
    void enterEnumBodyDeclarations(AsyncriptParser.EnumBodyDeclarationsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#enumBodyDeclarations}.
     *
     * @param ctx the parse tree
     */
    void exitEnumBodyDeclarations(AsyncriptParser.EnumBodyDeclarationsContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#interfaceDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterInterfaceDeclaration(AsyncriptParser.InterfaceDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#interfaceDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitInterfaceDeclaration(AsyncriptParser.InterfaceDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeList}.
     *
     * @param ctx the parse tree
     */
    void enterTypeList(AsyncriptParser.TypeListContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeList}.
     *
     * @param ctx the parse tree
     */
    void exitTypeList(AsyncriptParser.TypeListContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#classBody}.
     *
     * @param ctx the parse tree
     */
    void enterClassBody(AsyncriptParser.ClassBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#classBody}.
     *
     * @param ctx the parse tree
     */
    void exitClassBody(AsyncriptParser.ClassBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#interfaceBody}.
     *
     * @param ctx the parse tree
     */
    void enterInterfaceBody(AsyncriptParser.InterfaceBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#interfaceBody}.
     *
     * @param ctx the parse tree
     */
    void exitInterfaceBody(AsyncriptParser.InterfaceBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#classBodyDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterClassBodyDeclaration(AsyncriptParser.ClassBodyDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#classBodyDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitClassBodyDeclaration(AsyncriptParser.ClassBodyDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#memberDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterMemberDeclaration(AsyncriptParser.MemberDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#memberDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitMemberDeclaration(AsyncriptParser.MemberDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#methodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterMethodDeclaration(AsyncriptParser.MethodDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#methodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitMethodDeclaration(AsyncriptParser.MethodDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#genericMethodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterGenericMethodDeclaration(AsyncriptParser.GenericMethodDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#genericMethodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitGenericMethodDeclaration(AsyncriptParser.GenericMethodDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterConstructorDeclaration(AsyncriptParser.ConstructorDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#constructorDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitConstructorDeclaration(AsyncriptParser.ConstructorDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#genericConstructorDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterGenericConstructorDeclaration(AsyncriptParser.GenericConstructorDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#genericConstructorDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitGenericConstructorDeclaration(AsyncriptParser.GenericConstructorDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#fieldDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterFieldDeclaration(AsyncriptParser.FieldDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#fieldDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitFieldDeclaration(AsyncriptParser.FieldDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#interfaceBodyDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterInterfaceBodyDeclaration(AsyncriptParser.InterfaceBodyDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#interfaceBodyDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitInterfaceBodyDeclaration(AsyncriptParser.InterfaceBodyDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#interfaceMemberDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterInterfaceMemberDeclaration(AsyncriptParser.InterfaceMemberDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#interfaceMemberDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitInterfaceMemberDeclaration(AsyncriptParser.InterfaceMemberDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#constDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterConstDeclaration(AsyncriptParser.ConstDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#constDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitConstDeclaration(AsyncriptParser.ConstDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#constantDeclarator}.
     *
     * @param ctx the parse tree
     */
    void enterConstantDeclarator(AsyncriptParser.ConstantDeclaratorContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#constantDeclarator}.
     *
     * @param ctx the parse tree
     */
    void exitConstantDeclarator(AsyncriptParser.ConstantDeclaratorContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#interfaceMethodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterInterfaceMethodDeclaration(AsyncriptParser.InterfaceMethodDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#interfaceMethodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitInterfaceMethodDeclaration(AsyncriptParser.InterfaceMethodDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#genericInterfaceMethodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterGenericInterfaceMethodDeclaration(AsyncriptParser.GenericInterfaceMethodDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#genericInterfaceMethodDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitGenericInterfaceMethodDeclaration(AsyncriptParser.GenericInterfaceMethodDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#variableDeclarators}.
     *
     * @param ctx the parse tree
     */
    void enterVariableDeclarators(AsyncriptParser.VariableDeclaratorsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#variableDeclarators}.
     *
     * @param ctx the parse tree
     */
    void exitVariableDeclarators(AsyncriptParser.VariableDeclaratorsContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#variableDeclarator}.
     *
     * @param ctx the parse tree
     */
    void enterVariableDeclarator(AsyncriptParser.VariableDeclaratorContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#variableDeclarator}.
     *
     * @param ctx the parse tree
     */
    void exitVariableDeclarator(AsyncriptParser.VariableDeclaratorContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#variableDeclaratorId}.
     *
     * @param ctx the parse tree
     */
    void enterVariableDeclaratorId(AsyncriptParser.VariableDeclaratorIdContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#variableDeclaratorId}.
     *
     * @param ctx the parse tree
     */
    void exitVariableDeclaratorId(AsyncriptParser.VariableDeclaratorIdContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#variableInitializer}.
     *
     * @param ctx the parse tree
     */
    void enterVariableInitializer(AsyncriptParser.VariableInitializerContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#variableInitializer}.
     *
     * @param ctx the parse tree
     */
    void exitVariableInitializer(AsyncriptParser.VariableInitializerContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#arrayInitializer}.
     *
     * @param ctx the parse tree
     */
    void enterArrayInitializer(AsyncriptParser.ArrayInitializerContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#arrayInitializer}.
     *
     * @param ctx the parse tree
     */
    void exitArrayInitializer(AsyncriptParser.ArrayInitializerContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#enumConstantName}.
     *
     * @param ctx the parse tree
     */
    void enterEnumConstantName(AsyncriptParser.EnumConstantNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#enumConstantName}.
     *
     * @param ctx the parse tree
     */
    void exitEnumConstantName(AsyncriptParser.EnumConstantNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeType}.
     *
     * @param ctx the parse tree
     */
    void enterTypeType(AsyncriptParser.TypeTypeContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeType}.
     *
     * @param ctx the parse tree
     */
    void exitTypeType(AsyncriptParser.TypeTypeContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#classOrInterfaceType}.
     *
     * @param ctx the parse tree
     */
    void enterClassOrInterfaceType(AsyncriptParser.ClassOrInterfaceTypeContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#classOrInterfaceType}.
     *
     * @param ctx the parse tree
     */
    void exitClassOrInterfaceType(AsyncriptParser.ClassOrInterfaceTypeContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#primitiveType}.
     *
     * @param ctx the parse tree
     */
    void enterPrimitiveType(AsyncriptParser.PrimitiveTypeContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#primitiveType}.
     *
     * @param ctx the parse tree
     */
    void exitPrimitiveType(AsyncriptParser.PrimitiveTypeContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeArguments}.
     *
     * @param ctx the parse tree
     */
    void enterTypeArguments(AsyncriptParser.TypeArgumentsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeArguments}.
     *
     * @param ctx the parse tree
     */
    void exitTypeArguments(AsyncriptParser.TypeArgumentsContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeArgument}.
     *
     * @param ctx the parse tree
     */
    void enterTypeArgument(AsyncriptParser.TypeArgumentContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeArgument}.
     *
     * @param ctx the parse tree
     */
    void exitTypeArgument(AsyncriptParser.TypeArgumentContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#qualifiedNameList}.
     *
     * @param ctx the parse tree
     */
    void enterQualifiedNameList(AsyncriptParser.QualifiedNameListContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#qualifiedNameList}.
     *
     * @param ctx the parse tree
     */
    void exitQualifiedNameList(AsyncriptParser.QualifiedNameListContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#formalParameters}.
     *
     * @param ctx the parse tree
     */
    void enterFormalParameters(AsyncriptParser.FormalParametersContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#formalParameters}.
     *
     * @param ctx the parse tree
     */
    void exitFormalParameters(AsyncriptParser.FormalParametersContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#formalParameterList}.
     *
     * @param ctx the parse tree
     */
    void enterFormalParameterList(AsyncriptParser.FormalParameterListContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#formalParameterList}.
     *
     * @param ctx the parse tree
     */
    void exitFormalParameterList(AsyncriptParser.FormalParameterListContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#formalParameter}.
     *
     * @param ctx the parse tree
     */
    void enterFormalParameter(AsyncriptParser.FormalParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#formalParameter}.
     *
     * @param ctx the parse tree
     */
    void exitFormalParameter(AsyncriptParser.FormalParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#lastFormalParameter}.
     *
     * @param ctx the parse tree
     */
    void enterLastFormalParameter(AsyncriptParser.LastFormalParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#lastFormalParameter}.
     *
     * @param ctx the parse tree
     */
    void exitLastFormalParameter(AsyncriptParser.LastFormalParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#asyncMethodBody}.
     *
     * @param ctx the parse tree
     */
    void enterAsyncMethodBody(AsyncriptParser.AsyncMethodBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#asyncMethodBody}.
     *
     * @param ctx the parse tree
     */
    void exitAsyncMethodBody(AsyncriptParser.AsyncMethodBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#methodBody}.
     *
     * @param ctx the parse tree
     */
    void enterMethodBody(AsyncriptParser.MethodBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#methodBody}.
     *
     * @param ctx the parse tree
     */
    void exitMethodBody(AsyncriptParser.MethodBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#constructorBody}.
     *
     * @param ctx the parse tree
     */
    void enterConstructorBody(AsyncriptParser.ConstructorBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#constructorBody}.
     *
     * @param ctx the parse tree
     */
    void exitConstructorBody(AsyncriptParser.ConstructorBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#qualifiedName}.
     *
     * @param ctx the parse tree
     */
    void enterQualifiedName(AsyncriptParser.QualifiedNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#qualifiedName}.
     *
     * @param ctx the parse tree
     */
    void exitQualifiedName(AsyncriptParser.QualifiedNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#literal}.
     *
     * @param ctx the parse tree
     */
    void enterLiteral(AsyncriptParser.LiteralContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#literal}.
     *
     * @param ctx the parse tree
     */
    void exitLiteral(AsyncriptParser.LiteralContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotation}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotation(AsyncriptParser.AnnotationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotation}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotation(AsyncriptParser.AnnotationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationName}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationName(AsyncriptParser.AnnotationNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationName}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationName(AsyncriptParser.AnnotationNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#elementValuePairs}.
     *
     * @param ctx the parse tree
     */
    void enterElementValuePairs(AsyncriptParser.ElementValuePairsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#elementValuePairs}.
     *
     * @param ctx the parse tree
     */
    void exitElementValuePairs(AsyncriptParser.ElementValuePairsContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#elementValuePair}.
     *
     * @param ctx the parse tree
     */
    void enterElementValuePair(AsyncriptParser.ElementValuePairContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#elementValuePair}.
     *
     * @param ctx the parse tree
     */
    void exitElementValuePair(AsyncriptParser.ElementValuePairContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#elementValue}.
     *
     * @param ctx the parse tree
     */
    void enterElementValue(AsyncriptParser.ElementValueContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#elementValue}.
     *
     * @param ctx the parse tree
     */
    void exitElementValue(AsyncriptParser.ElementValueContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#elementValueArrayInitializer}.
     *
     * @param ctx the parse tree
     */
    void enterElementValueArrayInitializer(AsyncriptParser.ElementValueArrayInitializerContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#elementValueArrayInitializer}.
     *
     * @param ctx the parse tree
     */
    void exitElementValueArrayInitializer(AsyncriptParser.ElementValueArrayInitializerContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationTypeDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationTypeDeclaration(AsyncriptParser.AnnotationTypeDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationTypeDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationTypeDeclaration(AsyncriptParser.AnnotationTypeDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationTypeBody}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationTypeBody(AsyncriptParser.AnnotationTypeBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationTypeBody}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationTypeBody(AsyncriptParser.AnnotationTypeBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationTypeElementDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationTypeElementDeclaration(AsyncriptParser.AnnotationTypeElementDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationTypeElementDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationTypeElementDeclaration(AsyncriptParser.AnnotationTypeElementDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationTypeElementRest}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationTypeElementRest(AsyncriptParser.AnnotationTypeElementRestContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationTypeElementRest}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationTypeElementRest(AsyncriptParser.AnnotationTypeElementRestContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationMethodOrConstantRest}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationMethodOrConstantRest(AsyncriptParser.AnnotationMethodOrConstantRestContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationMethodOrConstantRest}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationMethodOrConstantRest(AsyncriptParser.AnnotationMethodOrConstantRestContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationMethodRest}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationMethodRest(AsyncriptParser.AnnotationMethodRestContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationMethodRest}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationMethodRest(AsyncriptParser.AnnotationMethodRestContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#annotationConstantRest}.
     *
     * @param ctx the parse tree
     */
    void enterAnnotationConstantRest(AsyncriptParser.AnnotationConstantRestContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#annotationConstantRest}.
     *
     * @param ctx the parse tree
     */
    void exitAnnotationConstantRest(AsyncriptParser.AnnotationConstantRestContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#defaultValue}.
     *
     * @param ctx the parse tree
     */
    void enterDefaultValue(AsyncriptParser.DefaultValueContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#defaultValue}.
     *
     * @param ctx the parse tree
     */
    void exitDefaultValue(AsyncriptParser.DefaultValueContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#block}.
     *
     * @param ctx the parse tree
     */
    void enterBlock(AsyncriptParser.BlockContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#block}.
     *
     * @param ctx the parse tree
     */
    void exitBlock(AsyncriptParser.BlockContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#blockStatement}.
     *
     * @param ctx the parse tree
     */
    void enterBlockStatement(AsyncriptParser.BlockStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#blockStatement}.
     *
     * @param ctx the parse tree
     */
    void exitBlockStatement(AsyncriptParser.BlockStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#localVariableDeclarationStatement}.
     *
     * @param ctx the parse tree
     */
    void enterLocalVariableDeclarationStatement(AsyncriptParser.LocalVariableDeclarationStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#localVariableDeclarationStatement}.
     *
     * @param ctx the parse tree
     */
    void exitLocalVariableDeclarationStatement(AsyncriptParser.LocalVariableDeclarationStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#localVariableDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterLocalVariableDeclaration(AsyncriptParser.LocalVariableDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#localVariableDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitLocalVariableDeclaration(AsyncriptParser.LocalVariableDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(AsyncriptParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(AsyncriptParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#catchClause}.
     *
     * @param ctx the parse tree
     */
    void enterCatchClause(AsyncriptParser.CatchClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#catchClause}.
     *
     * @param ctx the parse tree
     */
    void exitCatchClause(AsyncriptParser.CatchClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#catchType}.
     *
     * @param ctx the parse tree
     */
    void enterCatchType(AsyncriptParser.CatchTypeContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#catchType}.
     *
     * @param ctx the parse tree
     */
    void exitCatchType(AsyncriptParser.CatchTypeContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#finallyBlock}.
     *
     * @param ctx the parse tree
     */
    void enterFinallyBlock(AsyncriptParser.FinallyBlockContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#finallyBlock}.
     *
     * @param ctx the parse tree
     */
    void exitFinallyBlock(AsyncriptParser.FinallyBlockContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#resourceSpecification}.
     *
     * @param ctx the parse tree
     */
    void enterResourceSpecification(AsyncriptParser.ResourceSpecificationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#resourceSpecification}.
     *
     * @param ctx the parse tree
     */
    void exitResourceSpecification(AsyncriptParser.ResourceSpecificationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#resources}.
     *
     * @param ctx the parse tree
     */
    void enterResources(AsyncriptParser.ResourcesContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#resources}.
     *
     * @param ctx the parse tree
     */
    void exitResources(AsyncriptParser.ResourcesContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#resource}.
     *
     * @param ctx the parse tree
     */
    void enterResource(AsyncriptParser.ResourceContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#resource}.
     *
     * @param ctx the parse tree
     */
    void exitResource(AsyncriptParser.ResourceContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#switchBlockStatementGroup}.
     *
     * @param ctx the parse tree
     */
    void enterSwitchBlockStatementGroup(AsyncriptParser.SwitchBlockStatementGroupContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#switchBlockStatementGroup}.
     *
     * @param ctx the parse tree
     */
    void exitSwitchBlockStatementGroup(AsyncriptParser.SwitchBlockStatementGroupContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#switchLabel}.
     *
     * @param ctx the parse tree
     */
    void enterSwitchLabel(AsyncriptParser.SwitchLabelContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#switchLabel}.
     *
     * @param ctx the parse tree
     */
    void exitSwitchLabel(AsyncriptParser.SwitchLabelContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#forControl}.
     *
     * @param ctx the parse tree
     */
    void enterForControl(AsyncriptParser.ForControlContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#forControl}.
     *
     * @param ctx the parse tree
     */
    void exitForControl(AsyncriptParser.ForControlContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#forInit}.
     *
     * @param ctx the parse tree
     */
    void enterForInit(AsyncriptParser.ForInitContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#forInit}.
     *
     * @param ctx the parse tree
     */
    void exitForInit(AsyncriptParser.ForInitContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#enhancedForControl}.
     *
     * @param ctx the parse tree
     */
    void enterEnhancedForControl(AsyncriptParser.EnhancedForControlContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#enhancedForControl}.
     *
     * @param ctx the parse tree
     */
    void exitEnhancedForControl(AsyncriptParser.EnhancedForControlContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#forUpdate}.
     *
     * @param ctx the parse tree
     */
    void enterForUpdate(AsyncriptParser.ForUpdateContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#forUpdate}.
     *
     * @param ctx the parse tree
     */
    void exitForUpdate(AsyncriptParser.ForUpdateContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#parExpression}.
     *
     * @param ctx the parse tree
     */
    void enterParExpression(AsyncriptParser.ParExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#parExpression}.
     *
     * @param ctx the parse tree
     */
    void exitParExpression(AsyncriptParser.ParExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#expressionList}.
     *
     * @param ctx the parse tree
     */
    void enterExpressionList(AsyncriptParser.ExpressionListContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#expressionList}.
     *
     * @param ctx the parse tree
     */
    void exitExpressionList(AsyncriptParser.ExpressionListContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#statementExpression}.
     *
     * @param ctx the parse tree
     */
    void enterStatementExpression(AsyncriptParser.StatementExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#statementExpression}.
     *
     * @param ctx the parse tree
     */
    void exitStatementExpression(AsyncriptParser.StatementExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#constantExpression}.
     *
     * @param ctx the parse tree
     */
    void enterConstantExpression(AsyncriptParser.ConstantExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#constantExpression}.
     *
     * @param ctx the parse tree
     */
    void exitConstantExpression(AsyncriptParser.ConstantExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#awaitExpression}.
     *
     * @param ctx the parse tree
     */
    void enterAwaitExpression(AsyncriptParser.AwaitExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#awaitExpression}.
     *
     * @param ctx the parse tree
     */
    void exitAwaitExpression(AsyncriptParser.AwaitExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#expectExpression}.
     *
     * @param ctx the parse tree
     */
    void enterExpectExpression(AsyncriptParser.ExpectExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#expectExpression}.
     *
     * @param ctx the parse tree
     */
    void exitExpectExpression(AsyncriptParser.ExpectExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(AsyncriptParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(AsyncriptParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#primary}.
     *
     * @param ctx the parse tree
     */
    void enterPrimary(AsyncriptParser.PrimaryContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#primary}.
     *
     * @param ctx the parse tree
     */
    void exitPrimary(AsyncriptParser.PrimaryContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#creator}.
     *
     * @param ctx the parse tree
     */
    void enterCreator(AsyncriptParser.CreatorContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#creator}.
     *
     * @param ctx the parse tree
     */
    void exitCreator(AsyncriptParser.CreatorContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#createdName}.
     *
     * @param ctx the parse tree
     */
    void enterCreatedName(AsyncriptParser.CreatedNameContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#createdName}.
     *
     * @param ctx the parse tree
     */
    void exitCreatedName(AsyncriptParser.CreatedNameContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#innerCreator}.
     *
     * @param ctx the parse tree
     */
    void enterInnerCreator(AsyncriptParser.InnerCreatorContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#innerCreator}.
     *
     * @param ctx the parse tree
     */
    void exitInnerCreator(AsyncriptParser.InnerCreatorContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#arrayCreatorRest}.
     *
     * @param ctx the parse tree
     */
    void enterArrayCreatorRest(AsyncriptParser.ArrayCreatorRestContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#arrayCreatorRest}.
     *
     * @param ctx the parse tree
     */
    void exitArrayCreatorRest(AsyncriptParser.ArrayCreatorRestContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#classCreatorRest}.
     *
     * @param ctx the parse tree
     */
    void enterClassCreatorRest(AsyncriptParser.ClassCreatorRestContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#classCreatorRest}.
     *
     * @param ctx the parse tree
     */
    void exitClassCreatorRest(AsyncriptParser.ClassCreatorRestContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#explicitGenericInvocation}.
     *
     * @param ctx the parse tree
     */
    void enterExplicitGenericInvocation(AsyncriptParser.ExplicitGenericInvocationContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#explicitGenericInvocation}.
     *
     * @param ctx the parse tree
     */
    void exitExplicitGenericInvocation(AsyncriptParser.ExplicitGenericInvocationContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#nonWildcardTypeArguments}.
     *
     * @param ctx the parse tree
     */
    void enterNonWildcardTypeArguments(AsyncriptParser.NonWildcardTypeArgumentsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#nonWildcardTypeArguments}.
     *
     * @param ctx the parse tree
     */
    void exitNonWildcardTypeArguments(AsyncriptParser.NonWildcardTypeArgumentsContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#typeArgumentsOrDiamond}.
     *
     * @param ctx the parse tree
     */
    void enterTypeArgumentsOrDiamond(AsyncriptParser.TypeArgumentsOrDiamondContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#typeArgumentsOrDiamond}.
     *
     * @param ctx the parse tree
     */
    void exitTypeArgumentsOrDiamond(AsyncriptParser.TypeArgumentsOrDiamondContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#nonWildcardTypeArgumentsOrDiamond}.
     *
     * @param ctx the parse tree
     */
    void enterNonWildcardTypeArgumentsOrDiamond(AsyncriptParser.NonWildcardTypeArgumentsOrDiamondContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#nonWildcardTypeArgumentsOrDiamond}.
     *
     * @param ctx the parse tree
     */
    void exitNonWildcardTypeArgumentsOrDiamond(AsyncriptParser.NonWildcardTypeArgumentsOrDiamondContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#superSuffix}.
     *
     * @param ctx the parse tree
     */
    void enterSuperSuffix(AsyncriptParser.SuperSuffixContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#superSuffix}.
     *
     * @param ctx the parse tree
     */
    void exitSuperSuffix(AsyncriptParser.SuperSuffixContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#explicitGenericInvocationSuffix}.
     *
     * @param ctx the parse tree
     */
    void enterExplicitGenericInvocationSuffix(AsyncriptParser.ExplicitGenericInvocationSuffixContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#explicitGenericInvocationSuffix}.
     *
     * @param ctx the parse tree
     */
    void exitExplicitGenericInvocationSuffix(AsyncriptParser.ExplicitGenericInvocationSuffixContext ctx);

    /**
     * Enter a parse tree produced by {@link AsyncriptParser#arguments}.
     *
     * @param ctx the parse tree
     */
    void enterArguments(AsyncriptParser.ArgumentsContext ctx);

    /**
     * Exit a parse tree produced by {@link AsyncriptParser#arguments}.
     *
     * @param ctx the parse tree
     */
    void exitArguments(AsyncriptParser.ArgumentsContext ctx);
}
