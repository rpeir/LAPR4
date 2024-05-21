package eapli.ecourse.exammanagment.antlr4.exam;// Generated from Exam.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExamParser}.
 */
public interface ExamListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExamParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExamParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExamParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#exame}.
	 * @param ctx the parse tree
	 */
	void enterExame(ExamParser.ExameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#exame}.
	 * @param ctx the parse tree
	 */
	void exitExame(ExamParser.ExameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#regraTituloExame}.
	 * @param ctx the parse tree
	 */
	void enterRegraTituloExame(ExamParser.RegraTituloExameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#regraTituloExame}.
	 * @param ctx the parse tree
	 */
	void exitRegraTituloExame(ExamParser.RegraTituloExameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#regraHeaderExame}.
	 * @param ctx the parse tree
	 */
	void enterRegraHeaderExame(ExamParser.RegraHeaderExameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#regraHeaderExame}.
	 * @param ctx the parse tree
	 */
	void exitRegraHeaderExame(ExamParser.RegraHeaderExameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(ExamParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(ExamParser.FeedbackContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#grade}.
	 * @param ctx the parse tree
	 */
	void enterGrade(ExamParser.GradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#grade}.
	 * @param ctx the parse tree
	 */
	void exitGrade(ExamParser.GradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#seccao}.
	 * @param ctx the parse tree
	 */
	void enterSeccao(ExamParser.SeccaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#seccao}.
	 * @param ctx the parse tree
	 */
	void exitSeccao(ExamParser.SeccaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#startPergunta}.
	 * @param ctx the parse tree
	 */
	void enterStartPergunta(ExamParser.StartPerguntaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#startPergunta}.
	 * @param ctx the parse tree
	 */
	void exitStartPergunta(ExamParser.StartPerguntaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#pergunta}.
	 * @param ctx the parse tree
	 */
	void enterPergunta(ExamParser.PerguntaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#pergunta}.
	 * @param ctx the parse tree
	 */
	void exitPergunta(ExamParser.PerguntaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#frase}.
	 * @param ctx the parse tree
	 */
	void enterFrase(ExamParser.FraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#frase}.
	 * @param ctx the parse tree
	 */
	void exitFrase(ExamParser.FraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#palavra}.
	 * @param ctx the parse tree
	 */
	void enterPalavra(ExamParser.PalavraContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#palavra}.
	 * @param ctx the parse tree
	 */
	void exitPalavra(ExamParser.PalavraContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#listaPalavras}.
	 * @param ctx the parse tree
	 */
	void enterListaPalavras(ExamParser.ListaPalavrasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#listaPalavras}.
	 * @param ctx the parse tree
	 */
	void exitListaPalavras(ExamParser.ListaPalavrasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#listaPalavrasMatching}.
	 * @param ctx the parse tree
	 */
	void enterListaPalavrasMatching(ExamParser.ListaPalavrasMatchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#listaPalavrasMatching}.
	 * @param ctx the parse tree
	 */
	void exitListaPalavrasMatching(ExamParser.ListaPalavrasMatchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#fraseMissing}.
	 * @param ctx the parse tree
	 */
	void enterFraseMissing(ExamParser.FraseMissingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#fraseMissing}.
	 * @param ctx the parse tree
	 */
	void exitFraseMissing(ExamParser.FraseMissingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#regraPergunta}.
	 * @param ctx the parse tree
	 */
	void enterRegraPergunta(ExamParser.RegraPerguntaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#regraPergunta}.
	 * @param ctx the parse tree
	 */
	void exitRegraPergunta(ExamParser.RegraPerguntaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#regraMensagem}.
	 * @param ctx the parse tree
	 */
	void enterRegraMensagem(ExamParser.RegraMensagemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#regraMensagem}.
	 * @param ctx the parse tree
	 */
	void exitRegraMensagem(ExamParser.RegraMensagemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#pontucao}.
	 * @param ctx the parse tree
	 */
	void enterPontucao(ExamParser.PontucaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#pontucao}.
	 * @param ctx the parse tree
	 */
	void exitPontucao(ExamParser.PontucaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMatchingQuestion(ExamParser.MatchingQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matchingQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMatchingQuestion(ExamParser.MatchingQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNumericalQuestion(ExamParser.NumericalQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericalQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNumericalQuestion(ExamParser.NumericalQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleChoiceQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSingleChoiceQuestion(ExamParser.SingleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleChoiceQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSingleChoiceQuestion(ExamParser.SingleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multipleChoiceQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multipleChoiceQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMultipleChoiceQuestion(ExamParser.MultipleChoiceQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code missingWordsQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code missingWordsQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitMissingWordsQuestion(ExamParser.MissingWordsQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueFalseQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTrueFalseQuestion(ExamParser.TrueFalseQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shortAnsweQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void enterShortAnsweQuestion(ExamParser.ShortAnsweQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shortAnsweQuestion}
	 * labeled alternative in {@link ExamParser#type}.
	 * @param ctx the parse tree
	 */
	void exitShortAnsweQuestion(ExamParser.ShortAnsweQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#optionsMissing}.
	 * @param ctx the parse tree
	 */
	void enterOptionsMissing(ExamParser.OptionsMissingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#optionsMissing}.
	 * @param ctx the parse tree
	 */
	void exitOptionsMissing(ExamParser.OptionsMissingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#solucaoMissing}.
	 * @param ctx the parse tree
	 */
	void enterSolucaoMissing(ExamParser.SolucaoMissingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#solucaoMissing}.
	 * @param ctx the parse tree
	 */
	void exitSolucaoMissing(ExamParser.SolucaoMissingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#solucaoEscolha}.
	 * @param ctx the parse tree
	 */
	void enterSolucaoEscolha(ExamParser.SolucaoEscolhaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#solucaoEscolha}.
	 * @param ctx the parse tree
	 */
	void exitSolucaoEscolha(ExamParser.SolucaoEscolhaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#solucaoMatching}.
	 * @param ctx the parse tree
	 */
	void enterSolucaoMatching(ExamParser.SolucaoMatchingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#solucaoMatching}.
	 * @param ctx the parse tree
	 */
	void exitSolucaoMatching(ExamParser.SolucaoMatchingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#solucaoNumerical}.
	 * @param ctx the parse tree
	 */
	void enterSolucaoNumerical(ExamParser.SolucaoNumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#solucaoNumerical}.
	 * @param ctx the parse tree
	 */
	void exitSolucaoNumerical(ExamParser.SolucaoNumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#solucaoShort}.
	 * @param ctx the parse tree
	 */
	void enterSolucaoShort(ExamParser.SolucaoShortContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#solucaoShort}.
	 * @param ctx the parse tree
	 */
	void exitSolucaoShort(ExamParser.SolucaoShortContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#cotacao}.
	 * @param ctx the parse tree
	 */
	void enterCotacao(ExamParser.CotacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#cotacao}.
	 * @param ctx the parse tree
	 */
	void exitCotacao(ExamParser.CotacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#acceptedNumerical}.
	 * @param ctx the parse tree
	 */
	void enterAcceptedNumerical(ExamParser.AcceptedNumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#acceptedNumerical}.
	 * @param ctx the parse tree
	 */
	void exitAcceptedNumerical(ExamParser.AcceptedNumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#solucaoTrueFalse}.
	 * @param ctx the parse tree
	 */
	void enterSolucaoTrueFalse(ExamParser.SolucaoTrueFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#solucaoTrueFalse}.
	 * @param ctx the parse tree
	 */
	void exitSolucaoTrueFalse(ExamParser.SolucaoTrueFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#opcao}.
	 * @param ctx the parse tree
	 */
	void enterOpcao(ExamParser.OpcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#opcao}.
	 * @param ctx the parse tree
	 */
	void exitOpcao(ExamParser.OpcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#opcaoTrue}.
	 * @param ctx the parse tree
	 */
	void enterOpcaoTrue(ExamParser.OpcaoTrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#opcaoTrue}.
	 * @param ctx the parse tree
	 */
	void exitOpcaoTrue(ExamParser.OpcaoTrueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#opcaoFalse}.
	 * @param ctx the parse tree
	 */
	void enterOpcaoFalse(ExamParser.OpcaoFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#opcaoFalse}.
	 * @param ctx the parse tree
	 */
	void exitOpcaoFalse(ExamParser.OpcaoFalseContext ctx);
}