package eapli.ecourse.exammanagment.antlr4.exam;// Generated from Exam.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExamParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#exame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExame(ExamParser.ExameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#regraTituloExame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraTituloExame(ExamParser.RegraTituloExameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#regraHeaderExame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraHeaderExame(ExamParser.RegraHeaderExameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(ExamParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(ExamParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#seccao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccao(ExamParser.SeccaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#startPergunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartPergunta(ExamParser.StartPerguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#pergunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPergunta(ExamParser.PerguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#frase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrase(ExamParser.FraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#palavra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPalavra(ExamParser.PalavraContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#listaPalavras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaPalavras(ExamParser.ListaPalavrasContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#listaPalavrasMatching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaPalavrasMatching(ExamParser.ListaPalavrasMatchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#fraseMissing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraseMissing(ExamParser.FraseMissingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#regraPergunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraPergunta(ExamParser.RegraPerguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#regraMensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraMensagem(ExamParser.RegraMensagemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#pontucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPontucao(ExamParser.PontucaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(ExamParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(ExamParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleChoiceQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleChoiceQuestion(ExamParser.SingleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multipleChoiceQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code missingWordsQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortAnsweQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnsweQuestion(ExamParser.ShortAnsweQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#optionsMissing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionsMissing(ExamParser.OptionsMissingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#solucaoMissing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolucaoMissing(ExamParser.SolucaoMissingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#solucaoEscolha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolucaoEscolha(ExamParser.SolucaoEscolhaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#solucaoMatching}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolucaoMatching(ExamParser.SolucaoMatchingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#solucaoNumerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolucaoNumerical(ExamParser.SolucaoNumericalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#solucaoShort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolucaoShort(ExamParser.SolucaoShortContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#cotacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotacao(ExamParser.CotacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#acceptedNumerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceptedNumerical(ExamParser.AcceptedNumericalContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#solucaoTrueFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSolucaoTrueFalse(ExamParser.SolucaoTrueFalseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#opcao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcao(ExamParser.OpcaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#opcaoTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcaoTrue(ExamParser.OpcaoTrueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#opcaoFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpcaoFalse(ExamParser.OpcaoFalseContext ctx);
}