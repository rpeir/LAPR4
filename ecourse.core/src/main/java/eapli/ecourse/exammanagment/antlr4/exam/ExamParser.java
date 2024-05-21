package eapli.ecourse.exammanagment.antlr4.exam;// Generated from Exam.g4 by ANTLR 4.10.1

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExamParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, TRUE=5, FALSE=6, FEEDBACK=7, GRADE=8, 
		SECCAO=9, SOLUCAO=10, OPTIONS=11, ACCEPTED=12, MATCHING=13, SINGLE_CHOICE=14, 
		MULTIPLE_CHOICE=15, SHORT_ANSWER=16, NUMERIC=17, MISSING_WORDS=18, TRUE_FALSE=19, 
		DECIMALS_ALLOWED=20, MISSING_LEFT=21, MISSING_RIGHT=22, NUMERO=23, PALAVRA=24, 
		ASTERISCO=25, HIFEN=26, UNDERSCORE=27, ESPACO=28, PONTO_FINAL=29, DOIS_PONTOS=30, 
		RETICENCIAS=31, VIRGULA=32, PONTO_INTERROGACAO=33, PONTO_EXCLAMACAO=34, 
		PARENTESIS_DIREITO=35, PARENTESIS_ESQUERDO=36, WINDOWS_NEWLINE=37, NEWLINE=38;
	public static final int
		RULE_start = 0, RULE_exame = 1, RULE_regraTituloExame = 2, RULE_regraHeaderExame = 3, 
		RULE_feedback = 4, RULE_grade = 5, RULE_seccao = 6, RULE_startPergunta = 7, 
		RULE_pergunta = 8, RULE_frase = 9, RULE_palavra = 10, RULE_listaPalavras = 11, 
		RULE_listaPalavrasMatching = 12, RULE_fraseMissing = 13, RULE_regraPergunta = 14, 
		RULE_regraMensagem = 15, RULE_pontucao = 16, RULE_type = 17, RULE_optionsMissing = 18, 
		RULE_solucaoMissing = 19, RULE_solucaoEscolha = 20, RULE_solucaoMatching = 21, 
		RULE_solucaoNumerical = 22, RULE_solucaoShort = 23, RULE_cotacao = 24, 
		RULE_acceptedNumerical = 25, RULE_solucaoTrueFalse = 26, RULE_opcao = 27, 
		RULE_opcaoTrue = 28, RULE_opcaoFalse = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exame", "regraTituloExame", "regraHeaderExame", "feedback", 
			"grade", "seccao", "startPergunta", "pergunta", "frase", "palavra", "listaPalavras", 
			"listaPalavrasMatching", "fraseMissing", "regraPergunta", "regraMensagem", 
			"pontucao", "type", "optionsMissing", "solucaoMissing", "solucaoEscolha", 
			"solucaoMatching", "solucaoNumerical", "solucaoShort", "cotacao", "acceptedNumerical", 
			"solucaoTrueFalse", "opcao", "opcaoTrue", "opcaoFalse"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'QUESTION'", "'Theme: '", "'Type: '", "'Question value: '", "'True'", 
			"'False'", "'Feedback:'", "'Grade:'", "'Sec\\u00E7\\u00E3o'", "'Solution:'", 
			"'Options:'", "'Accepted: '", "'Matching'", "'Single-Choice'", "'Multiple-Choice'", 
			"'Short Answer'", "'Numeric'", "'Select Missing Words'", "'True or False'", 
			"'Decimal numbers are allowed!'", "'[['", "']]'", null, null, "'*'", 
			"'-'", "'_'", null, "'.'", "':'", "'...'", "','", "'?'", "'!'", "')'", 
			"'('", "'\\r\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "TRUE", "FALSE", "FEEDBACK", "GRADE", "SECCAO", 
			"SOLUCAO", "OPTIONS", "ACCEPTED", "MATCHING", "SINGLE_CHOICE", "MULTIPLE_CHOICE", 
			"SHORT_ANSWER", "NUMERIC", "MISSING_WORDS", "TRUE_FALSE", "DECIMALS_ALLOWED", 
			"MISSING_LEFT", "MISSING_RIGHT", "NUMERO", "PALAVRA", "ASTERISCO", "HIFEN", 
			"UNDERSCORE", "ESPACO", "PONTO_FINAL", "DOIS_PONTOS", "RETICENCIAS", 
			"VIRGULA", "PONTO_INTERROGACAO", "PONTO_EXCLAMACAO", "PARENTESIS_DIREITO", 
			"PARENTESIS_ESQUERDO", "WINDOWS_NEWLINE", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Exam.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public ExameContext exame() {
			return getRuleContext(ExameContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			exame();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExameContext extends ParserRuleContext {
		public RegraTituloExameContext regraTituloExame() {
			return getRuleContext(RegraTituloExameContext.class,0);
		}
		public RegraHeaderExameContext regraHeaderExame() {
			return getRuleContext(RegraHeaderExameContext.class,0);
		}
		public List<SeccaoContext> seccao() {
			return getRuleContexts(SeccaoContext.class);
		}
		public SeccaoContext seccao(int i) {
			return getRuleContext(SeccaoContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public ExameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterExame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitExame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitExame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExameContext exame() throws RecognitionException {
		ExameContext _localctx = new ExameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exame);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			regraTituloExame();
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
			setState(68);
			regraHeaderExame();
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					_la = _input.LA(1);
					if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
				setState(74);
				seccao();
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraTituloExameContext extends ParserRuleContext {
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public RegraTituloExameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraTituloExame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterRegraTituloExame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitRegraTituloExame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitRegraTituloExame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraTituloExameContext regraTituloExame() throws RecognitionException {
		RegraTituloExameContext _localctx = new RegraTituloExameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_regraTituloExame);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			frase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraHeaderExameContext extends ParserRuleContext {
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public GradeContext grade() {
			return getRuleContext(GradeContext.class,0);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public RegraHeaderExameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraHeaderExame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterRegraHeaderExame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitRegraHeaderExame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitRegraHeaderExame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraHeaderExameContext regraHeaderExame() throws RecognitionException {
		RegraHeaderExameContext _localctx = new RegraHeaderExameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_regraHeaderExame);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			feedback();
			setState(82);
			grade();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
				{
				setState(83);
				regraMensagem();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeedbackContext extends ParserRuleContext {
		public TerminalNode FEEDBACK() { return getToken(ExamParser.FEEDBACK, 0); }
		public TerminalNode ESPACO() { return getToken(ExamParser.ESPACO, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(FEEDBACK);
			setState(87);
			match(ESPACO);
			setState(88);
			frase();
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GradeContext extends ParserRuleContext {
		public TerminalNode GRADE() { return getToken(ExamParser.GRADE, 0); }
		public TerminalNode ESPACO() { return getToken(ExamParser.ESPACO, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public GradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterGrade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitGrade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitGrade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeContext grade() throws RecognitionException {
		GradeContext _localctx = new GradeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_grade);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(GRADE);
			setState(95);
			match(ESPACO);
			setState(96);
			frase();
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(97);
					_la = _input.LA(1);
					if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeccaoContext extends ParserRuleContext {
		public TerminalNode SECCAO() { return getToken(ExamParser.SECCAO, 0); }
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public List<PerguntaContext> pergunta() {
			return getRuleContexts(PerguntaContext.class);
		}
		public PerguntaContext pergunta(int i) {
			return getRuleContext(PerguntaContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(ExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(ExamParser.WINDOWS_NEWLINE, 0); }
		public SeccaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSeccao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSeccao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSeccao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccaoContext seccao() throws RecognitionException {
		SeccaoContext _localctx = new SeccaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_seccao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(SECCAO);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WINDOWS_NEWLINE || _la==NEWLINE) {
				{
				setState(103);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
				{
				setState(106);
				regraMensagem();
				}
			}

			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				pergunta();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartPerguntaContext extends ParserRuleContext {
		public List<PerguntaContext> pergunta() {
			return getRuleContexts(PerguntaContext.class);
		}
		public PerguntaContext pergunta(int i) {
			return getRuleContext(PerguntaContext.class,i);
		}
		public StartPerguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startPergunta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterStartPergunta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitStartPergunta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitStartPergunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartPerguntaContext startPergunta() throws RecognitionException {
		StartPerguntaContext _localctx = new StartPerguntaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_startPergunta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				pergunta();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PerguntaContext extends ParserRuleContext {
		public FraseContext theme;
		public RegraPerguntaContext regraPergunta() {
			return getRuleContext(RegraPerguntaContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public PerguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pergunta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterPergunta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitPergunta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitPergunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerguntaContext pergunta() throws RecognitionException {
		PerguntaContext _localctx = new PerguntaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pergunta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__0);
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(120);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(121);
				match(T__1);
				setState(122);
				((PerguntaContext)_localctx).theme = frase();
				}
				break;
			}
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(126);
			regraPergunta();
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
			setState(132);
			match(T__2);
			setState(133);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FraseContext extends ParserRuleContext {
		public List<PalavraContext> palavra() {
			return getRuleContexts(PalavraContext.class);
		}
		public PalavraContext palavra(int i) {
			return getRuleContext(PalavraContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(ExamParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(ExamParser.VIRGULA, i);
		}
		public List<TerminalNode> ESPACO() { return getTokens(ExamParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(ExamParser.ESPACO, i);
		}
		public FraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterFrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitFrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitFrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FraseContext frase() throws RecognitionException {
		FraseContext _localctx = new FraseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_frase);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			palavra();
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==VIRGULA) {
						{
						setState(136);
						match(VIRGULA);
						}
					}

					setState(140); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(139);
						match(ESPACO);
						}
						}
						setState(142); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==ESPACO );
					setState(144);
					palavra();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PalavraContext extends ParserRuleContext {
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public List<TerminalNode> HIFEN() { return getTokens(ExamParser.HIFEN); }
		public TerminalNode HIFEN(int i) {
			return getToken(ExamParser.HIFEN, i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(ExamParser.UNDERSCORE); }
		public TerminalNode UNDERSCORE(int i) {
			return getToken(ExamParser.UNDERSCORE, i);
		}
		public PalavraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_palavra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterPalavra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitPalavra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitPalavra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PalavraContext palavra() throws RecognitionException {
		PalavraContext _localctx = new PalavraContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_palavra);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(150);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(153); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaPalavrasContext extends ParserRuleContext {
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(ExamParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(ExamParser.VIRGULA, i);
		}
		public TerminalNode NEWLINE() { return getToken(ExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(ExamParser.WINDOWS_NEWLINE, 0); }
		public ListaPalavrasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaPalavras; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterListaPalavras(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitListaPalavras(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitListaPalavras(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaPalavrasContext listaPalavras() throws RecognitionException {
		ListaPalavrasContext _localctx = new ListaPalavrasContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listaPalavras);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(PALAVRA);
			setState(156);
			match(VIRGULA);
			setState(157);
			match(PALAVRA);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(158);
				match(VIRGULA);
				setState(159);
				match(PALAVRA);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			_la = _input.LA(1);
			if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaPalavrasMatchingContext extends ParserRuleContext {
		public List<TerminalNode> HIFEN() { return getTokens(ExamParser.HIFEN); }
		public TerminalNode HIFEN(int i) {
			return getToken(ExamParser.HIFEN, i);
		}
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(ExamParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(ExamParser.VIRGULA, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public ListaPalavrasMatchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaPalavrasMatching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterListaPalavrasMatching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitListaPalavrasMatching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitListaPalavrasMatching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListaPalavrasMatchingContext listaPalavrasMatching() throws RecognitionException {
		ListaPalavrasMatchingContext _localctx = new ListaPalavrasMatchingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listaPalavrasMatching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==PALAVRA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(168);
			match(HIFEN);
			setState(169);
			match(PALAVRA);
			setState(170);
			match(VIRGULA);
			setState(171);
			_la = _input.LA(1);
			if ( !(_la==NUMERO || _la==PALAVRA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(172);
			match(HIFEN);
			setState(173);
			match(PALAVRA);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(174);
				match(VIRGULA);
				setState(175);
				_la = _input.LA(1);
				if ( !(_la==NUMERO || _la==PALAVRA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(176);
				match(HIFEN);
				setState(177);
				match(PALAVRA);
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FraseMissingContext extends ParserRuleContext {
		public FraseContext part1;
		public Token mleft;
		public Token nr;
		public Token mright;
		public FraseContext part2;
		public List<TerminalNode> ESPACO() { return getTokens(ExamParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(ExamParser.ESPACO, i);
		}
		public List<FraseContext> frase() {
			return getRuleContexts(FraseContext.class);
		}
		public FraseContext frase(int i) {
			return getRuleContext(FraseContext.class,i);
		}
		public TerminalNode MISSING_LEFT() { return getToken(ExamParser.MISSING_LEFT, 0); }
		public TerminalNode NUMERO() { return getToken(ExamParser.NUMERO, 0); }
		public TerminalNode MISSING_RIGHT() { return getToken(ExamParser.MISSING_RIGHT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public FraseMissingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fraseMissing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterFraseMissing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitFraseMissing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitFraseMissing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FraseMissingContext fraseMissing() throws RecognitionException {
		FraseMissingContext _localctx = new FraseMissingContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fraseMissing);
		int _la;
		try {
			int _alt;
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((FraseMissingContext)_localctx).part1 = frase();
				setState(184);
				match(ESPACO);
				setState(185);
				((FraseMissingContext)_localctx).mleft = match(MISSING_LEFT);
				setState(186);
				((FraseMissingContext)_localctx).nr = match(NUMERO);
				setState(187);
				((FraseMissingContext)_localctx).mright = match(MISSING_RIGHT);
				setState(188);
				match(ESPACO);
				setState(189);
				((FraseMissingContext)_localctx).part2 = frase();
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(190);
						_la = _input.LA(1);
						if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(195);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				((FraseMissingContext)_localctx).part1 = frase();
				setState(197);
				match(ESPACO);
				setState(198);
				((FraseMissingContext)_localctx).mleft = match(MISSING_LEFT);
				setState(199);
				((FraseMissingContext)_localctx).nr = match(NUMERO);
				setState(200);
				((FraseMissingContext)_localctx).mright = match(MISSING_RIGHT);
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(201);
						_la = _input.LA(1);
						if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(206);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				((FraseMissingContext)_localctx).mleft = match(MISSING_LEFT);
				setState(208);
				((FraseMissingContext)_localctx).nr = match(NUMERO);
				setState(209);
				((FraseMissingContext)_localctx).mright = match(MISSING_RIGHT);
				setState(210);
				match(ESPACO);
				setState(211);
				((FraseMissingContext)_localctx).part2 = frase();
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(212);
						_la = _input.LA(1);
						if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(217);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraPerguntaContext extends ParserRuleContext {
		public FraseContext description;
		public Token ponto;
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public TerminalNode PONTO_INTERROGACAO() { return getToken(ExamParser.PONTO_INTERROGACAO, 0); }
		public TerminalNode PONTO_FINAL() { return getToken(ExamParser.PONTO_FINAL, 0); }
		public RegraPerguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraPergunta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterRegraPergunta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitRegraPergunta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitRegraPergunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraPerguntaContext regraPergunta() throws RecognitionException {
		RegraPerguntaContext _localctx = new RegraPerguntaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_regraPergunta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			((RegraPerguntaContext)_localctx).description = frase();
			setState(221);
			((RegraPerguntaContext)_localctx).ponto = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PONTO_FINAL || _la==PONTO_INTERROGACAO) ) {
				((RegraPerguntaContext)_localctx).ponto = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegraMensagemContext extends ParserRuleContext {
		public List<FraseContext> frase() {
			return getRuleContexts(FraseContext.class);
		}
		public FraseContext frase(int i) {
			return getRuleContext(FraseContext.class,i);
		}
		public List<PontucaoContext> pontucao() {
			return getRuleContexts(PontucaoContext.class);
		}
		public PontucaoContext pontucao(int i) {
			return getRuleContext(PontucaoContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public RegraMensagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraMensagem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterRegraMensagem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitRegraMensagem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitRegraMensagem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraMensagemContext regraMensagem() throws RecognitionException {
		RegraMensagemContext _localctx = new RegraMensagemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_regraMensagem);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(223);
				frase();
				setState(224);
				pontucao();
				setState(226); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(225);
						_la = _input.LA(1);
						if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(228); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PontucaoContext extends ParserRuleContext {
		public TerminalNode PONTO_FINAL() { return getToken(ExamParser.PONTO_FINAL, 0); }
		public TerminalNode PONTO_INTERROGACAO() { return getToken(ExamParser.PONTO_INTERROGACAO, 0); }
		public TerminalNode RETICENCIAS() { return getToken(ExamParser.RETICENCIAS, 0); }
		public TerminalNode PONTO_EXCLAMACAO() { return getToken(ExamParser.PONTO_EXCLAMACAO, 0); }
		public PontucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pontucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterPontucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitPontucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitPontucao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PontucaoContext pontucao() throws RecognitionException {
		PontucaoContext _localctx = new PontucaoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pontucao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PONTO_FINAL) | (1L << RETICENCIAS) | (1L << PONTO_INTERROGACAO) | (1L << PONTO_EXCLAMACAO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MissingWordsQuestionContext extends TypeContext {
		public Token tipo;
		public OptionsMissingContext opMissing;
		public SolucaoMissingContext missSolution;
		public TerminalNode OPTIONS() { return getToken(ExamParser.OPTIONS, 0); }
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode MISSING_WORDS() { return getToken(ExamParser.MISSING_WORDS, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public OptionsMissingContext optionsMissing() {
			return getRuleContext(OptionsMissingContext.class,0);
		}
		public SolucaoMissingContext solucaoMissing() {
			return getRuleContext(SolucaoMissingContext.class,0);
		}
		public List<FraseMissingContext> fraseMissing() {
			return getRuleContexts(FraseMissingContext.class);
		}
		public FraseMissingContext fraseMissing(int i) {
			return getRuleContext(FraseMissingContext.class,i);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public MissingWordsQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterMissingWordsQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitMissingWordsQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitMissingWordsQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericalQuestionContext extends TypeContext {
		public Token tipo;
		public SolucaoNumericalContext nSolution;
		public AcceptedNumericalContext acpError;
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public List<TerminalNode> ESPACO() { return getTokens(ExamParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(ExamParser.ESPACO, i);
		}
		public TerminalNode ACCEPTED() { return getToken(ExamParser.ACCEPTED, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode NUMERIC() { return getToken(ExamParser.NUMERIC, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public SolucaoNumericalContext solucaoNumerical() {
			return getRuleContext(SolucaoNumericalContext.class,0);
		}
		public AcceptedNumericalContext acceptedNumerical() {
			return getRuleContext(AcceptedNumericalContext.class,0);
		}
		public TerminalNode PARENTESIS_ESQUERDO() { return getToken(ExamParser.PARENTESIS_ESQUERDO, 0); }
		public TerminalNode DECIMALS_ALLOWED() { return getToken(ExamParser.DECIMALS_ALLOWED, 0); }
		public TerminalNode PARENTESIS_DIREITO() { return getToken(ExamParser.PARENTESIS_DIREITO, 0); }
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public NumericalQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterNumericalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitNumericalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitNumericalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultipleChoiceQuestionContext extends TypeContext {
		public Token tipo;
		public SolucaoEscolhaContext mcSolution;
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public TerminalNode ESPACO() { return getToken(ExamParser.ESPACO, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode MULTIPLE_CHOICE() { return getToken(ExamParser.MULTIPLE_CHOICE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public SolucaoEscolhaContext solucaoEscolha() {
			return getRuleContext(SolucaoEscolhaContext.class,0);
		}
		public List<OpcaoContext> opcao() {
			return getRuleContexts(OpcaoContext.class);
		}
		public OpcaoContext opcao(int i) {
			return getRuleContext(OpcaoContext.class,i);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public MultipleChoiceQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueFalseQuestionContext extends TypeContext {
		public Token tipo;
		public SolucaoTrueFalseContext tfSolution;
		public OpcaoTrueContext opcaoTrue() {
			return getRuleContext(OpcaoTrueContext.class,0);
		}
		public OpcaoFalseContext opcaoFalse() {
			return getRuleContext(OpcaoFalseContext.class,0);
		}
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public TerminalNode ESPACO() { return getToken(ExamParser.ESPACO, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode TRUE_FALSE() { return getToken(ExamParser.TRUE_FALSE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public SolucaoTrueFalseContext solucaoTrueFalse() {
			return getRuleContext(SolucaoTrueFalseContext.class,0);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public TrueFalseQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterTrueFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitTrueFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitTrueFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchingQuestionContext extends TypeContext {
		public Token tipo;
		public ListaPalavrasMatchingContext groupA;
		public ListaPalavrasMatchingContext groupB;
		public SolucaoMatchingContext mSolution;
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public TerminalNode ESPACO() { return getToken(ExamParser.ESPACO, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode MATCHING() { return getToken(ExamParser.MATCHING, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public List<ListaPalavrasMatchingContext> listaPalavrasMatching() {
			return getRuleContexts(ListaPalavrasMatchingContext.class);
		}
		public ListaPalavrasMatchingContext listaPalavrasMatching(int i) {
			return getRuleContext(ListaPalavrasMatchingContext.class,i);
		}
		public SolucaoMatchingContext solucaoMatching() {
			return getRuleContext(SolucaoMatchingContext.class,0);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public MatchingQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShortAnsweQuestionContext extends TypeContext {
		public Token tipo;
		public SolucaoShortContext shortSolution;
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode SHORT_ANSWER() { return getToken(ExamParser.SHORT_ANSWER, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public SolucaoShortContext solucaoShort() {
			return getRuleContext(SolucaoShortContext.class,0);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public ShortAnsweQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterShortAnsweQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitShortAnsweQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitShortAnsweQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleChoiceQuestionContext extends TypeContext {
		public Token tipo;
		public SolucaoEscolhaContext scSolution;
		public TerminalNode SOLUCAO() { return getToken(ExamParser.SOLUCAO, 0); }
		public TerminalNode ESPACO() { return getToken(ExamParser.ESPACO, 0); }
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode SINGLE_CHOICE() { return getToken(ExamParser.SINGLE_CHOICE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public SolucaoEscolhaContext solucaoEscolha() {
			return getRuleContext(SolucaoEscolhaContext.class,0);
		}
		public List<OpcaoContext> opcao() {
			return getRuleContexts(OpcaoContext.class);
		}
		public OpcaoContext opcao(int i) {
			return getRuleContext(OpcaoContext.class,i);
		}
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public SingleChoiceQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSingleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSingleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSingleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATCHING:
				_localctx = new MatchingQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				((MatchingQuestionContext)_localctx).tipo = match(MATCHING);
				setState(237);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(238);
				((MatchingQuestionContext)_localctx).groupA = listaPalavrasMatching();
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				((MatchingQuestionContext)_localctx).groupB = listaPalavrasMatching();
				setState(241);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(242);
				match(SOLUCAO);
				setState(243);
				match(ESPACO);
				setState(244);
				((MatchingQuestionContext)_localctx).mSolution = solucaoMatching();
				setState(245);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(246);
				cotacao();
				setState(247);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(248);
					regraMensagem();
					}
				}

				}
				break;
			case NUMERIC:
				_localctx = new NumericalQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				((NumericalQuestionContext)_localctx).tipo = match(NUMERIC);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ESPACO) {
					{
					setState(252);
					match(ESPACO);
					setState(253);
					match(PARENTESIS_ESQUERDO);
					setState(254);
					match(DECIMALS_ALLOWED);
					setState(255);
					match(PARENTESIS_DIREITO);
					}
				}

				setState(258);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(259);
				match(SOLUCAO);
				setState(260);
				match(ESPACO);
				setState(261);
				((NumericalQuestionContext)_localctx).nSolution = solucaoNumerical();
				setState(262);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(263);
				match(ACCEPTED);
				setState(264);
				((NumericalQuestionContext)_localctx).acpError = acceptedNumerical();
				setState(265);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(266);
				cotacao();
				setState(267);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(268);
					regraMensagem();
					}
				}

				}
				break;
			case SINGLE_CHOICE:
				_localctx = new SingleChoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				((SingleChoiceQuestionContext)_localctx).tipo = match(SINGLE_CHOICE);
				setState(272);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(273);
					opcao();
					}
					}
					setState(276); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PALAVRA );
				setState(278);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(279);
				match(SOLUCAO);
				setState(280);
				match(ESPACO);
				setState(281);
				((SingleChoiceQuestionContext)_localctx).scSolution = solucaoEscolha();
				setState(282);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(283);
				cotacao();
				setState(284);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(285);
					regraMensagem();
					}
				}

				}
				break;
			case MULTIPLE_CHOICE:
				_localctx = new MultipleChoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				((MultipleChoiceQuestionContext)_localctx).tipo = match(MULTIPLE_CHOICE);
				setState(289);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(291); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(290);
					opcao();
					}
					}
					setState(293); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PALAVRA );
				setState(295);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(296);
				match(SOLUCAO);
				setState(297);
				match(ESPACO);
				setState(298);
				((MultipleChoiceQuestionContext)_localctx).mcSolution = solucaoEscolha();
				setState(299);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(300);
				cotacao();
				setState(301);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(302);
					regraMensagem();
					}
				}

				}
				break;
			case MISSING_WORDS:
				_localctx = new MissingWordsQuestionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(305);
				((MissingWordsQuestionContext)_localctx).tipo = match(MISSING_WORDS);
				setState(306);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(308); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(307);
					fraseMissing();
					}
					}
					setState(310); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MISSING_LEFT) | (1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0) );
				setState(312);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(313);
				match(OPTIONS);
				setState(314);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(315);
				((MissingWordsQuestionContext)_localctx).opMissing = optionsMissing();
				setState(316);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(317);
				match(SOLUCAO);
				setState(318);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(319);
				((MissingWordsQuestionContext)_localctx).missSolution = solucaoMissing();
				setState(320);
				cotacao();
				setState(321);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(322);
					regraMensagem();
					}
				}

				}
				break;
			case TRUE_FALSE:
				_localctx = new TrueFalseQuestionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(325);
				((TrueFalseQuestionContext)_localctx).tipo = match(TRUE_FALSE);
				setState(326);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(327);
				opcaoTrue();
				setState(328);
				opcaoFalse();
				setState(329);
				match(SOLUCAO);
				setState(330);
				match(ESPACO);
				setState(331);
				((TrueFalseQuestionContext)_localctx).tfSolution = solucaoTrueFalse();
				setState(332);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(333);
				cotacao();
				setState(334);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(335);
					regraMensagem();
					}
				}

				}
				break;
			case SHORT_ANSWER:
				_localctx = new ShortAnsweQuestionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(338);
				((ShortAnsweQuestionContext)_localctx).tipo = match(SHORT_ANSWER);
				setState(339);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(340);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(341);
				match(SOLUCAO);
				setState(342);
				((ShortAnsweQuestionContext)_localctx).shortSolution = solucaoShort();
				setState(343);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(344);
				cotacao();
				setState(345);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
					{
					setState(346);
					regraMensagem();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionsMissingContext extends ParserRuleContext {
		public Token id;
		public ListaPalavrasContext des;
		public List<TerminalNode> MISSING_LEFT() { return getTokens(ExamParser.MISSING_LEFT); }
		public TerminalNode MISSING_LEFT(int i) {
			return getToken(ExamParser.MISSING_LEFT, i);
		}
		public List<TerminalNode> MISSING_RIGHT() { return getTokens(ExamParser.MISSING_RIGHT); }
		public TerminalNode MISSING_RIGHT(int i) {
			return getToken(ExamParser.MISSING_RIGHT, i);
		}
		public List<TerminalNode> ESPACO() { return getTokens(ExamParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(ExamParser.ESPACO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public List<ListaPalavrasContext> listaPalavras() {
			return getRuleContexts(ListaPalavrasContext.class);
		}
		public ListaPalavrasContext listaPalavras(int i) {
			return getRuleContext(ListaPalavrasContext.class,i);
		}
		public OptionsMissingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionsMissing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterOptionsMissing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitOptionsMissing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitOptionsMissing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionsMissingContext optionsMissing() throws RecognitionException {
		OptionsMissingContext _localctx = new OptionsMissingContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_optionsMissing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(351);
				match(MISSING_LEFT);
				setState(352);
				((OptionsMissingContext)_localctx).id = match(NUMERO);
				setState(353);
				match(MISSING_RIGHT);
				setState(354);
				match(ESPACO);
				setState(355);
				((OptionsMissingContext)_localctx).des = listaPalavras();
				}
				}
				setState(358); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MISSING_LEFT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolucaoMissingContext extends ParserRuleContext {
		public Token id;
		public Token des;
		public List<TerminalNode> MISSING_LEFT() { return getTokens(ExamParser.MISSING_LEFT); }
		public TerminalNode MISSING_LEFT(int i) {
			return getToken(ExamParser.MISSING_LEFT, i);
		}
		public List<TerminalNode> MISSING_RIGHT() { return getTokens(ExamParser.MISSING_RIGHT); }
		public TerminalNode MISSING_RIGHT(int i) {
			return getToken(ExamParser.MISSING_RIGHT, i);
		}
		public List<TerminalNode> ESPACO() { return getTokens(ExamParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(ExamParser.ESPACO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public SolucaoMissingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solucaoMissing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSolucaoMissing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSolucaoMissing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSolucaoMissing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolucaoMissingContext solucaoMissing() throws RecognitionException {
		SolucaoMissingContext _localctx = new SolucaoMissingContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_solucaoMissing);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(360);
				match(MISSING_LEFT);
				setState(361);
				((SolucaoMissingContext)_localctx).id = match(NUMERO);
				setState(362);
				match(MISSING_RIGHT);
				setState(363);
				match(ESPACO);
				setState(364);
				((SolucaoMissingContext)_localctx).des = match(PALAVRA);
				setState(365);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(368); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MISSING_LEFT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolucaoEscolhaContext extends ParserRuleContext {
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(ExamParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(ExamParser.VIRGULA, i);
		}
		public SolucaoEscolhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solucaoEscolha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSolucaoEscolha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSolucaoEscolha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSolucaoEscolha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolucaoEscolhaContext solucaoEscolha() throws RecognitionException {
		SolucaoEscolhaContext _localctx = new SolucaoEscolhaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_solucaoEscolha);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(PALAVRA);
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(371);
				match(VIRGULA);
				setState(372);
				match(PALAVRA);
				}
				}
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolucaoMatchingContext extends ParserRuleContext {
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> HIFEN() { return getTokens(ExamParser.HIFEN); }
		public TerminalNode HIFEN(int i) {
			return getToken(ExamParser.HIFEN, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(ExamParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(ExamParser.VIRGULA, i);
		}
		public SolucaoMatchingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solucaoMatching; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSolucaoMatching(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSolucaoMatching(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSolucaoMatching(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolucaoMatchingContext solucaoMatching() throws RecognitionException {
		SolucaoMatchingContext _localctx = new SolucaoMatchingContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_solucaoMatching);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(PALAVRA);
			setState(379);
			match(HIFEN);
			setState(380);
			match(NUMERO);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(381);
				match(VIRGULA);
				setState(382);
				match(PALAVRA);
				setState(383);
				match(HIFEN);
				setState(384);
				match(NUMERO);
				}
				}
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolucaoNumericalContext extends ParserRuleContext {
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public SolucaoNumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solucaoNumerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSolucaoNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSolucaoNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSolucaoNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolucaoNumericalContext solucaoNumerical() throws RecognitionException {
		SolucaoNumericalContext _localctx = new SolucaoNumericalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_solucaoNumerical);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(390);
				match(NUMERO);
				}
				}
				setState(393); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolucaoShortContext extends ParserRuleContext {
		public List<TerminalNode> HIFEN() { return getTokens(ExamParser.HIFEN); }
		public TerminalNode HIFEN(int i) {
			return getToken(ExamParser.HIFEN, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(ExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(ExamParser.WINDOWS_NEWLINE, i);
		}
		public List<TerminalNode> PALAVRA() { return getTokens(ExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(ExamParser.PALAVRA, i);
		}
		public List<TerminalNode> ASTERISCO() { return getTokens(ExamParser.ASTERISCO); }
		public TerminalNode ASTERISCO(int i) {
			return getToken(ExamParser.ASTERISCO, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public SolucaoShortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solucaoShort; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSolucaoShort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSolucaoShort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSolucaoShort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolucaoShortContext solucaoShort() throws RecognitionException {
		SolucaoShortContext _localctx = new SolucaoShortContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_solucaoShort);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(411); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(395);
					_la = _input.LA(1);
					if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(397); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(396);
						match(NUMERO);
						}
						}
						setState(399); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NUMERO );
					setState(401);
					match(HIFEN);
					setState(409);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						setState(402);
						match(PALAVRA);
						setState(403);
						match(ASTERISCO);
						setState(404);
						match(PALAVRA);
						}
						break;
					case 2:
						{
						setState(405);
						match(ASTERISCO);
						setState(406);
						match(PALAVRA);
						setState(407);
						match(ASTERISCO);
						}
						break;
					case 3:
						{
						setState(408);
						match(ASTERISCO);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(413); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CotacaoContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(ExamParser.NUMERO, 0); }
		public CotacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterCotacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitCotacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitCotacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotacaoContext cotacao() throws RecognitionException {
		CotacaoContext _localctx = new CotacaoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cotacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__3);
			setState(416);
			match(NUMERO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AcceptedNumericalContext extends ParserRuleContext {
		public List<TerminalNode> NUMERO() { return getTokens(ExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(ExamParser.NUMERO, i);
		}
		public AcceptedNumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceptedNumerical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterAcceptedNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitAcceptedNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitAcceptedNumerical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AcceptedNumericalContext acceptedNumerical() throws RecognitionException {
		AcceptedNumericalContext _localctx = new AcceptedNumericalContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_acceptedNumerical);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(418);
				match(NUMERO);
				}
				}
				setState(421); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SolucaoTrueFalseContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ExamParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ExamParser.FALSE, 0); }
		public SolucaoTrueFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solucaoTrueFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterSolucaoTrueFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitSolucaoTrueFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitSolucaoTrueFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolucaoTrueFalseContext solucaoTrueFalse() throws RecognitionException {
		SolucaoTrueFalseContext _localctx = new SolucaoTrueFalseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_solucaoTrueFalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpcaoContext extends ParserRuleContext {
		public Token opcaoID;
		public FraseContext opcaoDescription;
		public TerminalNode PARENTESIS_DIREITO() { return getToken(ExamParser.PARENTESIS_DIREITO, 0); }
		public TerminalNode PALAVRA() { return getToken(ExamParser.PALAVRA, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(ExamParser.WINDOWS_NEWLINE, 0); }
		public OpcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterOpcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitOpcao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitOpcao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcaoContext opcao() throws RecognitionException {
		OpcaoContext _localctx = new OpcaoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_opcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			((OpcaoContext)_localctx).opcaoID = match(PALAVRA);
			setState(426);
			match(PARENTESIS_DIREITO);
			setState(427);
			((OpcaoContext)_localctx).opcaoDescription = frase();
			setState(428);
			_la = _input.LA(1);
			if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpcaoTrueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ExamParser.TRUE, 0); }
		public TerminalNode NEWLINE() { return getToken(ExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(ExamParser.WINDOWS_NEWLINE, 0); }
		public OpcaoTrueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcaoTrue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterOpcaoTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitOpcaoTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitOpcaoTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcaoTrueContext opcaoTrue() throws RecognitionException {
		OpcaoTrueContext _localctx = new OpcaoTrueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_opcaoTrue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			match(TRUE);
			setState(431);
			_la = _input.LA(1);
			if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpcaoFalseContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(ExamParser.FALSE, 0); }
		public TerminalNode NEWLINE() { return getToken(ExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(ExamParser.WINDOWS_NEWLINE, 0); }
		public OpcaoFalseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opcaoFalse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).enterOpcaoFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener) ((ExamListener)listener).exitOpcaoFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor) return ((ExamVisitor<? extends T>)visitor).visitOpcaoFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcaoFalseContext opcaoFalse() throws RecognitionException {
		OpcaoFalseContext _localctx = new OpcaoFalseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_opcaoFalse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(FALSE);
			setState(434);
			_la = _input.LA(1);
			if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u01b5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0004\u0001A\b\u0001\u000b\u0001\f\u0001B\u0001"+
		"\u0001\u0001\u0001\u0004\u0001G\b\u0001\u000b\u0001\f\u0001H\u0001\u0001"+
		"\u0004\u0001L\b\u0001\u000b\u0001\f\u0001M\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u0004[\b\u0004\u000b\u0004\f\u0004"+
		"\\\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005c\b\u0005"+
		"\u000b\u0005\f\u0005d\u0001\u0006\u0001\u0006\u0003\u0006i\b\u0006\u0001"+
		"\u0006\u0003\u0006l\b\u0006\u0001\u0006\u0004\u0006o\b\u0006\u000b\u0006"+
		"\f\u0006p\u0001\u0007\u0004\u0007t\b\u0007\u000b\u0007\f\u0007u\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b|\b\b\u0001\b\u0001\b\u0001\b\u0004"+
		"\b\u0081\b\b\u000b\b\f\b\u0082\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0003\t\u008a\b\t\u0001\t\u0004\t\u008d\b\t\u000b\t\f\t\u008e\u0001\t"+
		"\u0005\t\u0092\b\t\n\t\f\t\u0095\t\t\u0001\n\u0004\n\u0098\b\n\u000b\n"+
		"\f\n\u0099\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00a1\b\u000b\n\u000b\f\u000b\u00a4\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u00b3\b\f\n\f\f\f\u00b6\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c0\b\r\n"+
		"\r\f\r\u00c3\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00cb\b\r\n\r\f\r\u00ce\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u00d6\b\r\n\r\f\r\u00d9\t\r\u0003\r\u00db\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f"+
		"\u00e3\b\u000f\u000b\u000f\f\u000f\u00e4\u0004\u000f\u00e7\b\u000f\u000b"+
		"\u000f\f\u000f\u00e8\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00fa"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0101\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u010e\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004"+
		"\u0011\u0113\b\u0011\u000b\u0011\f\u0011\u0114\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u011f\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011"+
		"\u0124\b\u0011\u000b\u0011\f\u0011\u0125\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0130\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u0135"+
		"\b\u0011\u000b\u0011\f\u0011\u0136\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u0144\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0151\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u015c\b\u0011\u0003\u0011\u015e\b"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0004"+
		"\u0012\u0165\b\u0012\u000b\u0012\f\u0012\u0166\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0004\u0013\u016f\b\u0013"+
		"\u000b\u0013\f\u0013\u0170\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0176\b\u0014\n\u0014\f\u0014\u0179\t\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0182"+
		"\b\u0015\n\u0015\f\u0015\u0185\t\u0015\u0001\u0016\u0004\u0016\u0188\b"+
		"\u0016\u000b\u0016\f\u0016\u0189\u0001\u0017\u0001\u0017\u0004\u0017\u018e"+
		"\b\u0017\u000b\u0017\f\u0017\u018f\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u019a\b\u0017\u0004\u0017\u019c\b\u0017\u000b\u0017\f\u0017\u019d\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0004\u0019\u01a4\b\u0019\u000b"+
		"\u0019\f\u0019\u01a5\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:\u0000\u0006\u0001\u0000%&\u0002\u0000\u0017\u0018\u001a"+
		"\u001b\u0001\u0000\u0017\u0018\u0002\u0000\u001d\u001d!!\u0003\u0000\u001d"+
		"\u001d\u001f\u001f!\"\u0001\u0000\u0005\u0006\u01ca\u0000<\u0001\u0000"+
		"\u0000\u0000\u0002>\u0001\u0000\u0000\u0000\u0004O\u0001\u0000\u0000\u0000"+
		"\u0006Q\u0001\u0000\u0000\u0000\bV\u0001\u0000\u0000\u0000\n^\u0001\u0000"+
		"\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000es\u0001\u0000\u0000\u0000"+
		"\u0010w\u0001\u0000\u0000\u0000\u0012\u0087\u0001\u0000\u0000\u0000\u0014"+
		"\u0097\u0001\u0000\u0000\u0000\u0016\u009b\u0001\u0000\u0000\u0000\u0018"+
		"\u00a7\u0001\u0000\u0000\u0000\u001a\u00da\u0001\u0000\u0000\u0000\u001c"+
		"\u00dc\u0001\u0000\u0000\u0000\u001e\u00e6\u0001\u0000\u0000\u0000 \u00ea"+
		"\u0001\u0000\u0000\u0000\"\u015d\u0001\u0000\u0000\u0000$\u0164\u0001"+
		"\u0000\u0000\u0000&\u016e\u0001\u0000\u0000\u0000(\u0172\u0001\u0000\u0000"+
		"\u0000*\u017a\u0001\u0000\u0000\u0000,\u0187\u0001\u0000\u0000\u0000."+
		"\u019b\u0001\u0000\u0000\u00000\u019f\u0001\u0000\u0000\u00002\u01a3\u0001"+
		"\u0000\u0000\u00004\u01a7\u0001\u0000\u0000\u00006\u01a9\u0001\u0000\u0000"+
		"\u00008\u01ae\u0001\u0000\u0000\u0000:\u01b1\u0001\u0000\u0000\u0000<"+
		"=\u0003\u0002\u0001\u0000=\u0001\u0001\u0000\u0000\u0000>@\u0003\u0004"+
		"\u0002\u0000?A\u0007\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DK\u0003\u0006\u0003\u0000EG\u0007\u0000\u0000"+
		"\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0003"+
		"\f\u0006\u0000KF\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0003\u0001\u0000\u0000"+
		"\u0000OP\u0003\u0012\t\u0000P\u0005\u0001\u0000\u0000\u0000QR\u0003\b"+
		"\u0004\u0000RT\u0003\n\u0005\u0000SU\u0003\u001e\u000f\u0000TS\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000U\u0007\u0001\u0000\u0000\u0000"+
		"VW\u0005\u0007\u0000\u0000WX\u0005\u001c\u0000\u0000XZ\u0003\u0012\t\u0000"+
		"Y[\u0007\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]\t\u0001"+
		"\u0000\u0000\u0000^_\u0005\b\u0000\u0000_`\u0005\u001c\u0000\u0000`b\u0003"+
		"\u0012\t\u0000ac\u0007\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"e\u000b\u0001\u0000\u0000\u0000fh\u0005\t\u0000\u0000gi\u0007\u0000\u0000"+
		"\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000"+
		"\u0000\u0000jl\u0003\u001e\u000f\u0000kj\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000ln\u0001\u0000\u0000\u0000mo\u0003\u0010\b\u0000nm\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000q\r\u0001\u0000\u0000\u0000rt\u0003\u0010\b"+
		"\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000v\u000f\u0001\u0000\u0000\u0000"+
		"w{\u0005\u0001\u0000\u0000xy\u0007\u0000\u0000\u0000yz\u0005\u0002\u0000"+
		"\u0000z|\u0003\u0012\t\u0000{x\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}~\u0007\u0000\u0000\u0000~\u0080\u0003"+
		"\u001c\u000e\u0000\u007f\u0081\u0007\u0000\u0000\u0000\u0080\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u0003\u0000\u0000\u0085\u0086\u0003"+
		"\"\u0011\u0000\u0086\u0011\u0001\u0000\u0000\u0000\u0087\u0093\u0003\u0014"+
		"\n\u0000\u0088\u008a\u0005 \u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\u0005\u001c\u0000\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000"+
		"\u0000\u0090\u0092\u0003\u0014\n\u0000\u0091\u0089\u0001\u0000\u0000\u0000"+
		"\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0013\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0098\u0007\u0001\u0000\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u0015\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0018\u0000\u0000"+
		"\u009c\u009d\u0005 \u0000\u0000\u009d\u00a2\u0005\u0018\u0000\u0000\u009e"+
		"\u009f\u0005 \u0000\u0000\u009f\u00a1\u0005\u0018\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0007\u0000\u0000\u0000\u00a6\u0017\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0007\u0002\u0000\u0000\u00a8\u00a9\u0005\u001a\u0000\u0000\u00a9\u00aa"+
		"\u0005\u0018\u0000\u0000\u00aa\u00ab\u0005 \u0000\u0000\u00ab\u00ac\u0007"+
		"\u0002\u0000\u0000\u00ac\u00ad\u0005\u001a\u0000\u0000\u00ad\u00b4\u0005"+
		"\u0018\u0000\u0000\u00ae\u00af\u0005 \u0000\u0000\u00af\u00b0\u0007\u0002"+
		"\u0000\u0000\u00b0\u00b1\u0005\u001a\u0000\u0000\u00b1\u00b3\u0005\u0018"+
		"\u0000\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u0019\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0003\u0012\t\u0000\u00b8\u00b9\u0005\u001c\u0000"+
		"\u0000\u00b9\u00ba\u0005\u0015\u0000\u0000\u00ba\u00bb\u0005\u0017\u0000"+
		"\u0000\u00bb\u00bc\u0005\u0016\u0000\u0000\u00bc\u00bd\u0005\u001c\u0000"+
		"\u0000\u00bd\u00c1\u0003\u0012\t\u0000\u00be\u00c0\u0007\u0000\u0000\u0000"+
		"\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00db\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0003\u0012\t\u0000\u00c5\u00c6\u0005\u001c\u0000\u0000\u00c6"+
		"\u00c7\u0005\u0015\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8"+
		"\u00cc\u0005\u0016\u0000\u0000\u00c9\u00cb\u0007\u0000\u0000\u0000\u00ca"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u00db\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005\u0015\u0000\u0000\u00d0\u00d1\u0005\u0017\u0000\u0000\u00d1"+
		"\u00d2\u0005\u0016\u0000\u0000\u00d2\u00d3\u0005\u001c\u0000\u0000\u00d3"+
		"\u00d7\u0003\u0012\t\u0000\u00d4\u00d6\u0007\u0000\u0000\u0000\u00d5\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00db"+
		"\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00b7"+
		"\u0001\u0000\u0000\u0000\u00da\u00c4\u0001\u0000\u0000\u0000\u00da\u00cf"+
		"\u0001\u0000\u0000\u0000\u00db\u001b\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0003\u0012\t\u0000\u00dd\u00de\u0007\u0003\u0000\u0000\u00de\u001d\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0003\u0012\t\u0000\u00e0\u00e2\u0003 "+
		"\u0010\u0000\u00e1\u00e3\u0007\u0000\u0000\u0000\u00e2\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e6\u00df\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u001f\u0001\u0000\u0000\u0000\u00ea\u00eb\u0007\u0004"+
		"\u0000\u0000\u00eb!\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\r\u0000"+
		"\u0000\u00ed\u00ee\u0007\u0000\u0000\u0000\u00ee\u00ef\u0003\u0018\f\u0000"+
		"\u00ef\u00f0\u0007\u0000\u0000\u0000\u00f0\u00f1\u0003\u0018\f\u0000\u00f1"+
		"\u00f2\u0007\u0000\u0000\u0000\u00f2\u00f3\u0005\n\u0000\u0000\u00f3\u00f4"+
		"\u0005\u001c\u0000\u0000\u00f4\u00f5\u0003*\u0015\u0000\u00f5\u00f6\u0007"+
		"\u0000\u0000\u0000\u00f6\u00f7\u00030\u0018\u0000\u00f7\u00f9\u0007\u0000"+
		"\u0000\u0000\u00f8\u00fa\u0003\u001e\u000f\u0000\u00f9\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u015e\u0001\u0000"+
		"\u0000\u0000\u00fb\u0100\u0005\u0011\u0000\u0000\u00fc\u00fd\u0005\u001c"+
		"\u0000\u0000\u00fd\u00fe\u0005$\u0000\u0000\u00fe\u00ff\u0005\u0014\u0000"+
		"\u0000\u00ff\u0101\u0005#\u0000\u0000\u0100\u00fc\u0001\u0000\u0000\u0000"+
		"\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0007\u0000\u0000\u0000\u0103\u0104\u0005\n\u0000\u0000\u0104"+
		"\u0105\u0005\u001c\u0000\u0000\u0105\u0106\u0003,\u0016\u0000\u0106\u0107"+
		"\u0007\u0000\u0000\u0000\u0107\u0108\u0005\f\u0000\u0000\u0108\u0109\u0003"+
		"2\u0019\u0000\u0109\u010a\u0007\u0000\u0000\u0000\u010a\u010b\u00030\u0018"+
		"\u0000\u010b\u010d\u0007\u0000\u0000\u0000\u010c\u010e\u0003\u001e\u000f"+
		"\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000"+
		"\u0000\u010e\u015e\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u000e\u0000"+
		"\u0000\u0110\u0112\u0007\u0000\u0000\u0000\u0111\u0113\u00036\u001b\u0000"+
		"\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000"+
		"\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0007\u0000\u0000\u0000"+
		"\u0117\u0118\u0005\n\u0000\u0000\u0118\u0119\u0005\u001c\u0000\u0000\u0119"+
		"\u011a\u0003(\u0014\u0000\u011a\u011b\u0007\u0000\u0000\u0000\u011b\u011c"+
		"\u00030\u0018\u0000\u011c\u011e\u0007\u0000\u0000\u0000\u011d\u011f\u0003"+
		"\u001e\u000f\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001"+
		"\u0000\u0000\u0000\u011f\u015e\u0001\u0000\u0000\u0000\u0120\u0121\u0005"+
		"\u000f\u0000\u0000\u0121\u0123\u0007\u0000\u0000\u0000\u0122\u0124\u0003"+
		"6\u001b\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000"+
		"\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000"+
		"\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128\u0007\u0000"+
		"\u0000\u0000\u0128\u0129\u0005\n\u0000\u0000\u0129\u012a\u0005\u001c\u0000"+
		"\u0000\u012a\u012b\u0003(\u0014\u0000\u012b\u012c\u0007\u0000\u0000\u0000"+
		"\u012c\u012d\u00030\u0018\u0000\u012d\u012f\u0007\u0000\u0000\u0000\u012e"+
		"\u0130\u0003\u001e\u000f\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u012f"+
		"\u0130\u0001\u0000\u0000\u0000\u0130\u015e\u0001\u0000\u0000\u0000\u0131"+
		"\u0132\u0005\u0012\u0000\u0000\u0132\u0134\u0007\u0000\u0000\u0000\u0133"+
		"\u0135\u0003\u001a\r\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0136"+
		"\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0007\u0000\u0000\u0000\u0139\u013a\u0005\u000b\u0000\u0000\u013a\u013b"+
		"\u0007\u0000\u0000\u0000\u013b\u013c\u0003$\u0012\u0000\u013c\u013d\u0007"+
		"\u0000\u0000\u0000\u013d\u013e\u0005\n\u0000\u0000\u013e\u013f\u0007\u0000"+
		"\u0000\u0000\u013f\u0140\u0003&\u0013\u0000\u0140\u0141\u00030\u0018\u0000"+
		"\u0141\u0143\u0007\u0000\u0000\u0000\u0142\u0144\u0003\u001e\u000f\u0000"+
		"\u0143\u0142\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000"+
		"\u0144\u015e\u0001\u0000\u0000\u0000\u0145\u0146\u0005\u0013\u0000\u0000"+
		"\u0146\u0147\u0007\u0000\u0000\u0000\u0147\u0148\u00038\u001c\u0000\u0148"+
		"\u0149\u0003:\u001d\u0000\u0149\u014a\u0005\n\u0000\u0000\u014a\u014b"+
		"\u0005\u001c\u0000\u0000\u014b\u014c\u00034\u001a\u0000\u014c\u014d\u0007"+
		"\u0000\u0000\u0000\u014d\u014e\u00030\u0018\u0000\u014e\u0150\u0007\u0000"+
		"\u0000\u0000\u014f\u0151\u0003\u001e\u000f\u0000\u0150\u014f\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u015e\u0001\u0000"+
		"\u0000\u0000\u0152\u0153\u0005\u0010\u0000\u0000\u0153\u0154\u0007\u0000"+
		"\u0000\u0000\u0154\u0155\u0007\u0000\u0000\u0000\u0155\u0156\u0005\n\u0000"+
		"\u0000\u0156\u0157\u0003.\u0017\u0000\u0157\u0158\u0007\u0000\u0000\u0000"+
		"\u0158\u0159\u00030\u0018\u0000\u0159\u015b\u0007\u0000\u0000\u0000\u015a"+
		"\u015c\u0003\u001e\u000f\u0000\u015b\u015a\u0001\u0000\u0000\u0000\u015b"+
		"\u015c\u0001\u0000\u0000\u0000\u015c\u015e\u0001\u0000\u0000\u0000\u015d"+
		"\u00ec\u0001\u0000\u0000\u0000\u015d\u00fb\u0001\u0000\u0000\u0000\u015d"+
		"\u010f\u0001\u0000\u0000\u0000\u015d\u0120\u0001\u0000\u0000\u0000\u015d"+
		"\u0131\u0001\u0000\u0000\u0000\u015d\u0145\u0001\u0000\u0000\u0000\u015d"+
		"\u0152\u0001\u0000\u0000\u0000\u015e#\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0005\u0015\u0000\u0000\u0160\u0161\u0005\u0017\u0000\u0000\u0161\u0162"+
		"\u0005\u0016\u0000\u0000\u0162\u0163\u0005\u001c\u0000\u0000\u0163\u0165"+
		"\u0003\u0016\u000b\u0000\u0164\u015f\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0001\u0000\u0000\u0000\u0167%\u0001\u0000\u0000\u0000\u0168\u0169\u0005"+
		"\u0015\u0000\u0000\u0169\u016a\u0005\u0017\u0000\u0000\u016a\u016b\u0005"+
		"\u0016\u0000\u0000\u016b\u016c\u0005\u001c\u0000\u0000\u016c\u016d\u0005"+
		"\u0018\u0000\u0000\u016d\u016f\u0007\u0000\u0000\u0000\u016e\u0168\u0001"+
		"\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u016e\u0001"+
		"\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\'\u0001\u0000"+
		"\u0000\u0000\u0172\u0177\u0005\u0018\u0000\u0000\u0173\u0174\u0005 \u0000"+
		"\u0000\u0174\u0176\u0005\u0018\u0000\u0000\u0175\u0173\u0001\u0000\u0000"+
		"\u0000\u0176\u0179\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000\u0000"+
		"\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178)\u0001\u0000\u0000\u0000"+
		"\u0179\u0177\u0001\u0000\u0000\u0000\u017a\u017b\u0005\u0018\u0000\u0000"+
		"\u017b\u017c\u0005\u001a\u0000\u0000\u017c\u0183\u0005\u0017\u0000\u0000"+
		"\u017d\u017e\u0005 \u0000\u0000\u017e\u017f\u0005\u0018\u0000\u0000\u017f"+
		"\u0180\u0005\u001a\u0000\u0000\u0180\u0182\u0005\u0017\u0000\u0000\u0181"+
		"\u017d\u0001\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184"+
		"+\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u0188"+
		"\u0005\u0017\u0000\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u0189"+
		"\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0001\u0000\u0000\u0000\u018a-\u0001\u0000\u0000\u0000\u018b\u018d\u0007"+
		"\u0000\u0000\u0000\u018c\u018e\u0005\u0017\u0000\u0000\u018d\u018c\u0001"+
		"\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u018d\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0001"+
		"\u0000\u0000\u0000\u0191\u0199\u0005\u001a\u0000\u0000\u0192\u0193\u0005"+
		"\u0018\u0000\u0000\u0193\u0194\u0005\u0019\u0000\u0000\u0194\u019a\u0005"+
		"\u0018\u0000\u0000\u0195\u0196\u0005\u0019\u0000\u0000\u0196\u0197\u0005"+
		"\u0018\u0000\u0000\u0197\u019a\u0005\u0019\u0000\u0000\u0198\u019a\u0005"+
		"\u0019\u0000\u0000\u0199\u0192\u0001\u0000\u0000\u0000\u0199\u0195\u0001"+
		"\u0000\u0000\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u019a\u019c\u0001"+
		"\u0000\u0000\u0000\u019b\u018b\u0001\u0000\u0000\u0000\u019c\u019d\u0001"+
		"\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019d\u019e\u0001"+
		"\u0000\u0000\u0000\u019e/\u0001\u0000\u0000\u0000\u019f\u01a0\u0005\u0004"+
		"\u0000\u0000\u01a0\u01a1\u0005\u0017\u0000\u0000\u01a11\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a4\u0005\u0017\u0000\u0000\u01a3\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a63\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a8\u0007\u0005\u0000\u0000\u01a85\u0001\u0000\u0000\u0000\u01a9"+
		"\u01aa\u0005\u0018\u0000\u0000\u01aa\u01ab\u0005#\u0000\u0000\u01ab\u01ac"+
		"\u0003\u0012\t\u0000\u01ac\u01ad\u0007\u0000\u0000\u0000\u01ad7\u0001"+
		"\u0000\u0000\u0000\u01ae\u01af\u0005\u0005\u0000\u0000\u01af\u01b0\u0007"+
		"\u0000\u0000\u0000\u01b09\u0001\u0000\u0000\u0000\u01b1\u01b2\u0005\u0006"+
		"\u0000\u0000\u01b2\u01b3\u0007\u0000\u0000\u0000\u01b3;\u0001\u0000\u0000"+
		"\u0000-BHMT\\dhkpu{\u0082\u0089\u008e\u0093\u0099\u00a2\u00b4\u00c1\u00cc"+
		"\u00d7\u00da\u00e4\u00e8\u00f9\u0100\u010d\u0114\u011e\u0125\u012f\u0136"+
		"\u0143\u0150\u015b\u015d\u0166\u0170\u0177\u0183\u0189\u018f\u0199\u019d"+
		"\u01a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}