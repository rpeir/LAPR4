package eapli.ecourse.exammanagment.antlr4.formativeexam;// Generated from FormativeExam.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormativeExamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormativeExamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FormativeExamParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#exame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExame(FormativeExamParser.ExameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#regraTituloExame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraTituloExame(FormativeExamParser.RegraTituloExameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#regraHeaderExame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraHeaderExame(FormativeExamParser.RegraHeaderExameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(FormativeExamParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(FormativeExamParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#seccao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccao(FormativeExamParser.SeccaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#pergunta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPergunta(FormativeExamParser.PerguntaContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#frase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrase(FormativeExamParser.FraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#palavra}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPalavra(FormativeExamParser.PalavraContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#regraMensagem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegraMensagem(FormativeExamParser.RegraMensagemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#pontucao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPontucao(FormativeExamParser.PontucaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchingQuestion(FormativeExamParser.MatchingQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalQuestion(FormativeExamParser.NumericalQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleChoiceQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleChoiceQuestion(FormativeExamParser.SingleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multipleChoiceQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleChoiceQuestion(FormativeExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code missingWordsQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissingWordsQuestion(FormativeExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueFalseQuestion(FormativeExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shortAnsweQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortAnsweQuestion(FormativeExamParser.ShortAnsweQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamParser#cotacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCotacao(FormativeExamParser.CotacaoContext ctx);
}