grammar FormativeExam;

//------- REGRAS -------

start: exame;

exame: regraTituloExame (NEWLINE|WINDOWS_NEWLINE)+ regraHeaderExame ((NEWLINE|WINDOWS_NEWLINE)+ seccao)+;

regraTituloExame: frase;

regraHeaderExame: feedback grade (regraMensagem)?;

feedback: FEEDBACK ESPACO frase (NEWLINE|WINDOWS_NEWLINE)+;

grade: GRADE ESPACO frase (NEWLINE|WINDOWS_NEWLINE)+;

seccao: SECCAO (NEWLINE|WINDOWS_NEWLINE)? regraMensagem? pergunta+ ;

pergunta: 'QUESTION' (NEWLINE|WINDOWS_NEWLINE) 'Type: ' type (NEWLINE|WINDOWS_NEWLINE)+;

frase : palavra (VIRGULA? ESPACO+ palavra)*;

palavra: ( PALAVRA | NUMERO | HIFEN | UNDERSCORE )+;

regraMensagem: (frase pontucao (NEWLINE|WINDOWS_NEWLINE)+)+ ;

pontucao: PONTO_FINAL | PONTO_INTERROGACAO | RETICENCIAS | PONTO_EXCLAMACAO;

type: tipo = MATCHING (NEWLINE|WINDOWS_NEWLINE) cotacao #matchingQuestion
 | tipo = NUMERIC (NEWLINE|WINDOWS_NEWLINE) cotacao #numericalQuestion
 | tipo = SINGLE_CHOICE (NEWLINE|WINDOWS_NEWLINE) cotacao #singleChoiceQuestion
 | tipo = MULTIPLE_CHOICE (NEWLINE|WINDOWS_NEWLINE) cotacao #multipleChoiceQuestion
 | tipo = MISSING_WORDS (NEWLINE|WINDOWS_NEWLINE) cotacao #missingWordsQuestion
 | tipo = TRUE_FALSE (NEWLINE|WINDOWS_NEWLINE) cotacao #trueFalseQuestion
 | tipo = SHORT_ANSWER (NEWLINE|WINDOWS_NEWLINE) cotacao #shortAnsweQuestion
 ;

cotacao: 'Question value: ' NUMERO;

//------- TOKENS -------

TRUE: 'True';
FALSE: 'False';
FEEDBACK: 'Feedback:';
GRADE: 'Grade:';
SECCAO: 'Secção';
SOLUCAO: 'Solution:';
OPTIONS: 'Options:';
ACCEPTED: 'Accepted: ';

//- Types of Questions -

MATCHING: 'Matching';
SINGLE_CHOICE:'Single-Choice';
MULTIPLE_CHOICE:'Multiple-Choice';
SHORT_ANSWER: 'Short Answer';
NUMERIC: 'Numeric';
MISSING_WORDS: 'Select Missing Words';
TRUE_FALSE: 'True or False';

DECIMALS_ALLOWED: 'Decimal numbers are allowed!';
MISSING_LEFT: '[[';
MISSING_RIGHT: ']]';

NUMERO: [0-9];
PALAVRA: [a-zA-Z]+;

ASTERISCO: '*';
HIFEN: '-';
UNDERSCORE: '_';
ESPACO: ' '|'\t';
PONTO_FINAL: '.';
DOIS_PONTOS: ':';
RETICENCIAS: '...';
VIRGULA: ',';
PONTO_INTERROGACAO: '?';
PONTO_EXCLAMACAO: '!';
PARENTESIS_DIREITO: ')';
PARENTESIS_ESQUERDO: '(';
WINDOWS_NEWLINE: '\r\n';
NEWLINE : [\r\n] ;

