package eapli.ecourse.exammanagment.antlr4.formativeexam;// Generated from FormativeExam.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormativeExamParser}.
 */
public interface FormativeExamListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(FormativeExamParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(FormativeExamParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#exame}.
	 * @param ctx the parse tree
	 */
	void enterExame(FormativeExamParser.ExameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#exame}.
	 * @param ctx the parse tree
	 */
	void exitExame(FormativeExamParser.ExameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#regraTituloExame}.
	 * @param ctx the parse tree
	 */
	void enterRegraTituloExame(FormativeExamParser.RegraTituloExameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#regraTituloExame}.
	 * @param ctx the parse tree
	 */
	void exitRegraTituloExame(FormativeExamParser.RegraTituloExameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#regraHeaderExame}.
	 * @param ctx the parse tree
	 */
	void enterRegraHeaderExame(FormativeExamParser.RegraHeaderExameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#regraHeaderExame}.
	 * @param ctx the parse tree
	 */
	void exitRegraHeaderExame(FormativeExamParser.RegraHeaderExameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(FormativeExamParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(FormativeExamParser.FeedbackContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#grade}.
	 * @param ctx the parse tree
	 */
	void enterGrade(FormativeExamParser.GradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#grade}.
	 * @param ctx the parse tree
	 */
	void exitGrade(FormativeExamParser.GradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#seccao}.
	 * @param ctx the parse tree
	 */
	void enterSeccao(FormativeExamParser.SeccaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#seccao}.
	 * @param ctx the parse tree
	 */
	void exitSeccao(FormativeExamParser.SeccaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#pergunta}.
	 * @param ctx the parse tree
	 */
	void enterPergunta(FormativeExamParser.PerguntaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#pergunta}.
	 * @param ctx the parse tree
	 */
	void exitPergunta(FormativeExamParser.PerguntaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#frase}.
	 * @param ctx the parse tree
	 */
	void enterFrase(FormativeExamParser.FraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#frase}.
	 * @param ctx the parse tree
	 */
	void exitFrase(FormativeExamParser.FraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#palavra}.
	 * @param ctx the parse tree
	 */
	void enterPalavra(FormativeExamParser.PalavraContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#palavra}.
	 * @param ctx the parse tree
	 */
	void exitPalavra(FormativeExamParser.PalavraContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#regraMensagem}.
	 * @param ctx the parse tree
	 */
	void enterRegraMensagem(FormativeExamParser.RegraMensagemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#regraMensagem}.
	 * @param ctx the parse tree
	 */
	void exitRegraMensagem(FormativeExamParser.RegraMensagemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#pontucao}.
	 * @param ctx the parse tree
	 */
	void enterPontucao(FormativeExamParser.PontucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#pontucao}.
	 * @param ctx the parse tree
	 */
	void exitPontucao(FormativeExamParser.PontucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(FormativeExamParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(FormativeExamParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(FormativeExamParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(FormativeExamParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleChoiceQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSingleChoiceQuestion(FormativeExamParser.SingleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleChoiceQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSingleChoiceQuestion(FormativeExamParser.SingleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multipleChoiceQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(FormativeExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multipleChoiceQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(FormativeExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code missingWordsQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMissingWordsQuestion(FormativeExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code missingWordsQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMissingWordsQuestion(FormativeExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseQuestion(FormativeExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseQuestion(FormativeExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shortAnsweQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterShortAnsweQuestion(FormativeExamParser.ShortAnsweQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shortAnsweQuestion}
	 * labeled alternative in {@link FormativeExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitShortAnsweQuestion(FormativeExamParser.ShortAnsweQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamParser#cotacao}.
	 * @param ctx the parse tree
	 */
	void enterCotacao(FormativeExamParser.CotacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamParser#cotacao}.
	 * @param ctx the parse tree
	 */
	void exitCotacao(FormativeExamParser.CotacaoContext ctx);
}