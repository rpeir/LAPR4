package eapli.ecourse.exammanagment.antlr4.formativeexam;// Generated from FormativeExam.g4 by ANTLR 4.10.1

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
public class FormativeExamParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, TRUE=4, FALSE=5, FEEDBACK=6, GRADE=7, SECCAO=8, 
		SOLUCAO=9, OPTIONS=10, ACCEPTED=11, MATCHING=12, SINGLE_CHOICE=13, MULTIPLE_CHOICE=14, 
		SHORT_ANSWER=15, NUMERIC=16, MISSING_WORDS=17, TRUE_FALSE=18, DECIMALS_ALLOWED=19, 
		MISSING_LEFT=20, MISSING_RIGHT=21, NUMERO=22, PALAVRA=23, ASTERISCO=24, 
		HIFEN=25, UNDERSCORE=26, ESPACO=27, PONTO_FINAL=28, DOIS_PONTOS=29, RETICENCIAS=30, 
		VIRGULA=31, PONTO_INTERROGACAO=32, PONTO_EXCLAMACAO=33, PARENTESIS_DIREITO=34, 
		PARENTESIS_ESQUERDO=35, WINDOWS_NEWLINE=36, NEWLINE=37;
	public static final int
		RULE_start = 0, RULE_exame = 1, RULE_regraTituloExame = 2, RULE_regraHeaderExame = 3, 
		RULE_feedback = 4, RULE_grade = 5, RULE_seccao = 6, RULE_pergunta = 7, 
		RULE_frase = 8, RULE_palavra = 9, RULE_regraMensagem = 10, RULE_pontucao = 11, 
		RULE_type = 12, RULE_cotacao = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exame", "regraTituloExame", "regraHeaderExame", "feedback", 
			"grade", "seccao", "pergunta", "frase", "palavra", "regraMensagem", "pontucao", 
			"type", "cotacao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'QUESTION'", "'Type: '", "'Question value: '", "'True'", "'False'", 
			"'Feedback:'", "'Grade:'", "'Sec\\u00E7\\u00E3o'", "'Solution:'", "'Options:'", 
			"'Accepted: '", "'Matching'", "'Single-Choice'", "'Multiple-Choice'", 
			"'Short Answer'", "'Numeric'", "'Select Missing Words'", "'True or False'", 
			"'Decimal numbers are allowed!'", "'[['", "']]'", null, null, "'*'", 
			"'-'", "'_'", null, "'.'", "':'", "'...'", "','", "'?'", "'!'", "')'", 
			"'('", "'\\r\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "TRUE", "FALSE", "FEEDBACK", "GRADE", "SECCAO", 
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
	public String getGrammarFileName() { return "FormativeExam.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormativeExamParser(TokenStream input) {
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
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
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
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(FormativeExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(FormativeExamParser.WINDOWS_NEWLINE, i);
		}
		public ExameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterExame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitExame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitExame(this);
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
			setState(30);
			regraTituloExame();
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
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
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
			setState(36);
			regraHeaderExame();
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(37);
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
					setState(40); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WINDOWS_NEWLINE || _la==NEWLINE );
				setState(42);
				seccao();
				}
				}
				setState(45); 
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
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterRegraTituloExame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitRegraTituloExame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitRegraTituloExame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraTituloExameContext regraTituloExame() throws RecognitionException {
		RegraTituloExameContext _localctx = new RegraTituloExameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_regraTituloExame);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
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
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterRegraHeaderExame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitRegraHeaderExame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitRegraHeaderExame(this);
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
			setState(49);
			feedback();
			setState(50);
			grade();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
				{
				setState(51);
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
		public TerminalNode FEEDBACK() { return getToken(FormativeExamParser.FEEDBACK, 0); }
		public TerminalNode ESPACO() { return getToken(FormativeExamParser.ESPACO, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(FormativeExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(FormativeExamParser.WINDOWS_NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitFeedback(this);
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
			setState(54);
			match(FEEDBACK);
			setState(55);
			match(ESPACO);
			setState(56);
			frase();
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
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
				setState(60); 
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
		public TerminalNode GRADE() { return getToken(FormativeExamParser.GRADE, 0); }
		public TerminalNode ESPACO() { return getToken(FormativeExamParser.ESPACO, 0); }
		public FraseContext frase() {
			return getRuleContext(FraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(FormativeExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(FormativeExamParser.WINDOWS_NEWLINE, i);
		}
		public GradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterGrade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitGrade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitGrade(this);
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
			setState(62);
			match(GRADE);
			setState(63);
			match(ESPACO);
			setState(64);
			frase();
			setState(66); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(65);
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
				setState(68); 
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
		public TerminalNode SECCAO() { return getToken(FormativeExamParser.SECCAO, 0); }
		public RegraMensagemContext regraMensagem() {
			return getRuleContext(RegraMensagemContext.class,0);
		}
		public List<PerguntaContext> pergunta() {
			return getRuleContexts(PerguntaContext.class);
		}
		public PerguntaContext pergunta(int i) {
			return getRuleContext(PerguntaContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public SeccaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterSeccao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitSeccao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitSeccao(this);
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
			setState(70);
			match(SECCAO);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WINDOWS_NEWLINE || _la==NEWLINE) {
				{
				setState(71);
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

			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMERO) | (1L << PALAVRA) | (1L << HIFEN) | (1L << UNDERSCORE))) != 0)) {
				{
				setState(74);
				regraMensagem();
				}
			}

			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				pergunta();
				}
				}
				setState(80); 
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(FormativeExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(FormativeExamParser.WINDOWS_NEWLINE, i);
		}
		public PerguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pergunta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterPergunta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitPergunta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitPergunta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerguntaContext pergunta() throws RecognitionException {
		PerguntaContext _localctx = new PerguntaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pergunta);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__0);
			setState(83);
			_la = _input.LA(1);
			if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(84);
			match(T__1);
			setState(85);
			type();
			setState(87); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(86);
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
				setState(89); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class FraseContext extends ParserRuleContext {
		public List<PalavraContext> palavra() {
			return getRuleContexts(PalavraContext.class);
		}
		public PalavraContext palavra(int i) {
			return getRuleContext(PalavraContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(FormativeExamParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(FormativeExamParser.VIRGULA, i);
		}
		public List<TerminalNode> ESPACO() { return getTokens(FormativeExamParser.ESPACO); }
		public TerminalNode ESPACO(int i) {
			return getToken(FormativeExamParser.ESPACO, i);
		}
		public FraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterFrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitFrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitFrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FraseContext frase() throws RecognitionException {
		FraseContext _localctx = new FraseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_frase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			palavra();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESPACO || _la==VIRGULA) {
				{
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VIRGULA) {
					{
					setState(92);
					match(VIRGULA);
					}
				}

				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(ESPACO);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ESPACO );
				setState(100);
				palavra();
				}
				}
				setState(105);
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

	public static class PalavraContext extends ParserRuleContext {
		public List<TerminalNode> PALAVRA() { return getTokens(FormativeExamParser.PALAVRA); }
		public TerminalNode PALAVRA(int i) {
			return getToken(FormativeExamParser.PALAVRA, i);
		}
		public List<TerminalNode> NUMERO() { return getTokens(FormativeExamParser.NUMERO); }
		public TerminalNode NUMERO(int i) {
			return getToken(FormativeExamParser.NUMERO, i);
		}
		public List<TerminalNode> HIFEN() { return getTokens(FormativeExamParser.HIFEN); }
		public TerminalNode HIFEN(int i) {
			return getToken(FormativeExamParser.HIFEN, i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(FormativeExamParser.UNDERSCORE); }
		public TerminalNode UNDERSCORE(int i) {
			return getToken(FormativeExamParser.UNDERSCORE, i);
		}
		public PalavraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_palavra; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterPalavra(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitPalavra(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitPalavra(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PalavraContext palavra() throws RecognitionException {
		PalavraContext _localctx = new PalavraContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_palavra);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
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
				setState(109); 
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
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamParser.NEWLINE, i);
		}
		public List<TerminalNode> WINDOWS_NEWLINE() { return getTokens(FormativeExamParser.WINDOWS_NEWLINE); }
		public TerminalNode WINDOWS_NEWLINE(int i) {
			return getToken(FormativeExamParser.WINDOWS_NEWLINE, i);
		}
		public RegraMensagemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regraMensagem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterRegraMensagem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitRegraMensagem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitRegraMensagem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegraMensagemContext regraMensagem() throws RecognitionException {
		RegraMensagemContext _localctx = new RegraMensagemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_regraMensagem);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				frase();
				setState(112);
				pontucao();
				setState(114); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(113);
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
					setState(116); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(120); 
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
		public TerminalNode PONTO_FINAL() { return getToken(FormativeExamParser.PONTO_FINAL, 0); }
		public TerminalNode PONTO_INTERROGACAO() { return getToken(FormativeExamParser.PONTO_INTERROGACAO, 0); }
		public TerminalNode RETICENCIAS() { return getToken(FormativeExamParser.RETICENCIAS, 0); }
		public TerminalNode PONTO_EXCLAMACAO() { return getToken(FormativeExamParser.PONTO_EXCLAMACAO, 0); }
		public PontucaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pontucao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterPontucao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitPontucao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitPontucao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PontucaoContext pontucao() throws RecognitionException {
		PontucaoContext _localctx = new PontucaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pontucao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode MISSING_WORDS() { return getToken(FormativeExamParser.MISSING_WORDS, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public MissingWordsQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterMissingWordsQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitMissingWordsQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitMissingWordsQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericalQuestionContext extends TypeContext {
		public Token tipo;
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode NUMERIC() { return getToken(FormativeExamParser.NUMERIC, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public NumericalQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterNumericalQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitNumericalQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitNumericalQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultipleChoiceQuestionContext extends TypeContext {
		public Token tipo;
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode MULTIPLE_CHOICE() { return getToken(FormativeExamParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public MultipleChoiceQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterMultipleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitMultipleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitMultipleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueFalseQuestionContext extends TypeContext {
		public Token tipo;
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode TRUE_FALSE() { return getToken(FormativeExamParser.TRUE_FALSE, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public TrueFalseQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterTrueFalseQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitTrueFalseQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitTrueFalseQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchingQuestionContext extends TypeContext {
		public Token tipo;
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode MATCHING() { return getToken(FormativeExamParser.MATCHING, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public MatchingQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterMatchingQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitMatchingQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitMatchingQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShortAnsweQuestionContext extends TypeContext {
		public Token tipo;
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode SHORT_ANSWER() { return getToken(FormativeExamParser.SHORT_ANSWER, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public ShortAnsweQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterShortAnsweQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitShortAnsweQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitShortAnsweQuestion(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleChoiceQuestionContext extends TypeContext {
		public Token tipo;
		public CotacaoContext cotacao() {
			return getRuleContext(CotacaoContext.class,0);
		}
		public TerminalNode SINGLE_CHOICE() { return getToken(FormativeExamParser.SINGLE_CHOICE, 0); }
		public TerminalNode NEWLINE() { return getToken(FormativeExamParser.NEWLINE, 0); }
		public TerminalNode WINDOWS_NEWLINE() { return getToken(FormativeExamParser.WINDOWS_NEWLINE, 0); }
		public SingleChoiceQuestionContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterSingleChoiceQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitSingleChoiceQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitSingleChoiceQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATCHING:
				_localctx = new MatchingQuestionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				((MatchingQuestionContext)_localctx).tipo = match(MATCHING);
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
				cotacao();
				}
				break;
			case NUMERIC:
				_localctx = new NumericalQuestionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				((NumericalQuestionContext)_localctx).tipo = match(NUMERIC);
				setState(128);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(129);
				cotacao();
				}
				break;
			case SINGLE_CHOICE:
				_localctx = new SingleChoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				((SingleChoiceQuestionContext)_localctx).tipo = match(SINGLE_CHOICE);
				setState(131);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(132);
				cotacao();
				}
				break;
			case MULTIPLE_CHOICE:
				_localctx = new MultipleChoiceQuestionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				((MultipleChoiceQuestionContext)_localctx).tipo = match(MULTIPLE_CHOICE);
				setState(134);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(135);
				cotacao();
				}
				break;
			case MISSING_WORDS:
				_localctx = new MissingWordsQuestionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				((MissingWordsQuestionContext)_localctx).tipo = match(MISSING_WORDS);
				setState(137);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				cotacao();
				}
				break;
			case TRUE_FALSE:
				_localctx = new TrueFalseQuestionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				((TrueFalseQuestionContext)_localctx).tipo = match(TRUE_FALSE);
				setState(140);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(141);
				cotacao();
				}
				break;
			case SHORT_ANSWER:
				_localctx = new ShortAnsweQuestionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(142);
				((ShortAnsweQuestionContext)_localctx).tipo = match(SHORT_ANSWER);
				setState(143);
				_la = _input.LA(1);
				if ( !(_la==WINDOWS_NEWLINE || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(144);
				cotacao();
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

	public static class CotacaoContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(FormativeExamParser.NUMERO, 0); }
		public CotacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cotacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).enterCotacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamListener ) ((FormativeExamListener)listener).exitCotacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamVisitor ) return ((FormativeExamVisitor<? extends T>)visitor).visitCotacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CotacaoContext cotacao() throws RecognitionException {
		CotacaoContext _localctx = new CotacaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cotacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__2);
			setState(148);
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

	public static final String _serializedATN =
		"\u0004\u0001%\u0097\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0004\u0001!\b\u0001\u000b\u0001\f\u0001\"\u0001\u0001\u0001\u0001\u0004"+
		"\u0001\'\b\u0001\u000b\u0001\f\u0001(\u0001\u0001\u0004\u0001,\b\u0001"+
		"\u000b\u0001\f\u0001-\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u00035\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0004\u0004;\b\u0004\u000b\u0004\f\u0004<\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005C\b\u0005\u000b\u0005\f\u0005"+
		"D\u0001\u0006\u0001\u0006\u0003\u0006I\b\u0006\u0001\u0006\u0003\u0006"+
		"L\b\u0006\u0001\u0006\u0004\u0006O\b\u0006\u000b\u0006\f\u0006P\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007X\b"+
		"\u0007\u000b\u0007\f\u0007Y\u0001\b\u0001\b\u0003\b^\b\b\u0001\b\u0004"+
		"\ba\b\b\u000b\b\f\bb\u0001\b\u0005\bf\b\b\n\b\f\bi\t\b\u0001\t\u0004\t"+
		"l\b\t\u000b\t\f\tm\u0001\n\u0001\n\u0001\n\u0004\ns\b\n\u000b\n\f\nt\u0004"+
		"\nw\b\n\u000b\n\f\nx\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0092\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0003"+
		"\u0001\u0000$%\u0002\u0000\u0016\u0017\u0019\u001a\u0003\u0000\u001c\u001c"+
		"\u001e\u001e !\u009e\u0000\u001c\u0001\u0000\u0000\u0000\u0002\u001e\u0001"+
		"\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u00061\u0001\u0000\u0000"+
		"\u0000\b6\u0001\u0000\u0000\u0000\n>\u0001\u0000\u0000\u0000\fF\u0001"+
		"\u0000\u0000\u0000\u000eR\u0001\u0000\u0000\u0000\u0010[\u0001\u0000\u0000"+
		"\u0000\u0012k\u0001\u0000\u0000\u0000\u0014v\u0001\u0000\u0000\u0000\u0016"+
		"z\u0001\u0000\u0000\u0000\u0018\u0091\u0001\u0000\u0000\u0000\u001a\u0093"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d\u0001"+
		"\u0001\u0000\u0000\u0000\u001e \u0003\u0004\u0002\u0000\u001f!\u0007\u0000"+
		"\u0000\u0000 \u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000"+
		"\u0000$+\u0003\u0006\u0003\u0000%\'\u0007\u0000\u0000\u0000&%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0003\f\u0006\u0000+&\u0001"+
		"\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0003\u0010"+
		"\b\u00000\u0005\u0001\u0000\u0000\u000012\u0003\b\u0004\u000024\u0003"+
		"\n\u0005\u000035\u0003\u0014\n\u000043\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u00005\u0007\u0001\u0000\u0000\u000067\u0005\u0006\u0000"+
		"\u000078\u0005\u001b\u0000\u00008:\u0003\u0010\b\u00009;\u0007\u0000\u0000"+
		"\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=\t\u0001\u0000\u0000\u0000>?\u0005"+
		"\u0007\u0000\u0000?@\u0005\u001b\u0000\u0000@B\u0003\u0010\b\u0000AC\u0007"+
		"\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u000b\u0001\u0000"+
		"\u0000\u0000FH\u0005\b\u0000\u0000GI\u0007\u0000\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JL\u0003"+
		"\u0014\n\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001"+
		"\u0000\u0000\u0000MO\u0003\u000e\u0007\u0000NM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000Q\r\u0001\u0000\u0000\u0000RS\u0005\u0001\u0000\u0000ST\u0007\u0000"+
		"\u0000\u0000TU\u0005\u0002\u0000\u0000UW\u0003\u0018\f\u0000VX\u0007\u0000"+
		"\u0000\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u000f\u0001\u0000\u0000"+
		"\u0000[g\u0003\u0012\t\u0000\\^\u0005\u001f\u0000\u0000]\\\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_a\u0005"+
		"\u001b\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000df\u0003\u0012\t\u0000e]\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0011\u0001"+
		"\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0007\u0001\u0000\u0000"+
		"kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000n\u0013\u0001\u0000\u0000\u0000op\u0003"+
		"\u0010\b\u0000pr\u0003\u0016\u000b\u0000qs\u0007\u0000\u0000\u0000rq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vo\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000y\u0015\u0001\u0000\u0000\u0000z{\u0007\u0002\u0000\u0000"+
		"{\u0017\u0001\u0000\u0000\u0000|}\u0005\f\u0000\u0000}~\u0007\u0000\u0000"+
		"\u0000~\u0092\u0003\u001a\r\u0000\u007f\u0080\u0005\u0010\u0000\u0000"+
		"\u0080\u0081\u0007\u0000\u0000\u0000\u0081\u0092\u0003\u001a\r\u0000\u0082"+
		"\u0083\u0005\r\u0000\u0000\u0083\u0084\u0007\u0000\u0000\u0000\u0084\u0092"+
		"\u0003\u001a\r\u0000\u0085\u0086\u0005\u000e\u0000\u0000\u0086\u0087\u0007"+
		"\u0000\u0000\u0000\u0087\u0092\u0003\u001a\r\u0000\u0088\u0089\u0005\u0011"+
		"\u0000\u0000\u0089\u008a\u0007\u0000\u0000\u0000\u008a\u0092\u0003\u001a"+
		"\r\u0000\u008b\u008c\u0005\u0012\u0000\u0000\u008c\u008d\u0007\u0000\u0000"+
		"\u0000\u008d\u0092\u0003\u001a\r\u0000\u008e\u008f\u0005\u000f\u0000\u0000"+
		"\u008f\u0090\u0007\u0000\u0000\u0000\u0090\u0092\u0003\u001a\r\u0000\u0091"+
		"|\u0001\u0000\u0000\u0000\u0091\u007f\u0001\u0000\u0000\u0000\u0091\u0082"+
		"\u0001\u0000\u0000\u0000\u0091\u0085\u0001\u0000\u0000\u0000\u0091\u0088"+
		"\u0001\u0000\u0000\u0000\u0091\u008b\u0001\u0000\u0000\u0000\u0091\u008e"+
		"\u0001\u0000\u0000\u0000\u0092\u0019\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0005\u0003\u0000\u0000\u0094\u0095\u0005\u0016\u0000\u0000\u0095\u001b"+
		"\u0001\u0000\u0000\u0000\u0011\"(-4<DHKPY]bgmtx\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}