grammar Exam;

//------- REGRAS -------

start: exame;

exame: regraTituloExame (NEWLINE|WINDOWS_NEWLINE)+ regraHeaderExame ((NEWLINE|WINDOWS_NEWLINE)+ seccao)+;

regraTituloExame: frase;

regraHeaderExame: feedback grade (regraMensagem)?;

feedback: FEEDBACK ESPACO frase (NEWLINE|WINDOWS_NEWLINE)+;

grade: GRADE ESPACO frase (NEWLINE|WINDOWS_NEWLINE)+;

seccao: SECCAO (NEWLINE|WINDOWS_NEWLINE)? regraMensagem? pergunta+ ;

startPergunta: (pergunta)+ ;

pergunta: 'QUESTION' ((NEWLINE|WINDOWS_NEWLINE) 'Theme: ' theme = frase)? (NEWLINE|WINDOWS_NEWLINE) regraPergunta (NEWLINE|WINDOWS_NEWLINE)+ 'Type: ' type ;

frase : palavra (VIRGULA? ESPACO+ palavra)*;

palavra: ( PALAVRA | NUMERO | HIFEN | UNDERSCORE )+;

listaPalavras: PALAVRA VIRGULA PALAVRA (VIRGULA PALAVRA)* (NEWLINE|WINDOWS_NEWLINE);

listaPalavrasMatching: (PALAVRA | NUMERO ) HIFEN PALAVRA VIRGULA (PALAVRA | NUMERO ) HIFEN PALAVRA (VIRGULA (PALAVRA | NUMERO ) HIFEN PALAVRA)*;

fraseMissing: part1 = frase ESPACO mleft = MISSING_LEFT nr = NUMERO mright = MISSING_RIGHT ESPACO part2 = frase ((NEWLINE|WINDOWS_NEWLINE))*
            | part1 = frase ESPACO mleft = MISSING_LEFT nr = NUMERO mright = MISSING_RIGHT ((NEWLINE|WINDOWS_NEWLINE))*
            | mleft = MISSING_LEFT nr = NUMERO mright = MISSING_RIGHT ESPACO part2 = frase ((NEWLINE|WINDOWS_NEWLINE))*
            ;

regraPergunta: description = frase ponto =(PONTO_INTERROGACAO | PONTO_FINAL);

regraMensagem: (frase pontucao (NEWLINE|WINDOWS_NEWLINE)+)+ ;

pontucao: PONTO_FINAL | PONTO_INTERROGACAO | RETICENCIAS | PONTO_EXCLAMACAO;

type: tipo = MATCHING (NEWLINE|WINDOWS_NEWLINE) groupA = listaPalavrasMatching (NEWLINE|WINDOWS_NEWLINE) groupB = listaPalavrasMatching (NEWLINE|WINDOWS_NEWLINE)  SOLUCAO ESPACO mSolution = solucaoMatching (NEWLINE|WINDOWS_NEWLINE) cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)?  #matchingQuestion
 | tipo = NUMERIC (ESPACO PARENTESIS_ESQUERDO DECIMALS_ALLOWED PARENTESIS_DIREITO)? (NEWLINE|WINDOWS_NEWLINE) SOLUCAO ESPACO nSolution = solucaoNumerical (NEWLINE|WINDOWS_NEWLINE) ACCEPTED acpError = acceptedNumerical (NEWLINE|WINDOWS_NEWLINE) cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)? #numericalQuestion
 | tipo = SINGLE_CHOICE (NEWLINE|WINDOWS_NEWLINE)  (opcao)+ (NEWLINE|WINDOWS_NEWLINE) SOLUCAO ESPACO scSolution = solucaoEscolha (NEWLINE|WINDOWS_NEWLINE) cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)? #singleChoiceQuestion
 | tipo = MULTIPLE_CHOICE (NEWLINE|WINDOWS_NEWLINE) (opcao)+ (NEWLINE|WINDOWS_NEWLINE) SOLUCAO ESPACO mcSolution = solucaoEscolha (NEWLINE|WINDOWS_NEWLINE) cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)? #multipleChoiceQuestion
 | tipo = MISSING_WORDS (NEWLINE|WINDOWS_NEWLINE) (fraseMissing)+ (NEWLINE|WINDOWS_NEWLINE) OPTIONS (NEWLINE|WINDOWS_NEWLINE) opMissing = optionsMissing (NEWLINE|WINDOWS_NEWLINE) SOLUCAO (NEWLINE|WINDOWS_NEWLINE) missSolution = solucaoMissing cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)? #missingWordsQuestion
 | tipo = TRUE_FALSE (NEWLINE|WINDOWS_NEWLINE) opcaoTrue opcaoFalse SOLUCAO ESPACO tfSolution = solucaoTrueFalse (NEWLINE|WINDOWS_NEWLINE) cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)? #trueFalseQuestion
 | tipo = SHORT_ANSWER (NEWLINE|WINDOWS_NEWLINE) (NEWLINE|WINDOWS_NEWLINE) SOLUCAO shortSolution = solucaoShort (NEWLINE|WINDOWS_NEWLINE) cotacao (NEWLINE|WINDOWS_NEWLINE) (regraMensagem)? #shortAnsweQuestion
 ;

optionsMissing: (MISSING_LEFT  id = NUMERO MISSING_RIGHT ESPACO  des =listaPalavras)+;

solucaoMissing: (MISSING_LEFT  id = NUMERO MISSING_RIGHT ESPACO  des = PALAVRA (NEWLINE|WINDOWS_NEWLINE))+;

solucaoEscolha: PALAVRA (VIRGULA PALAVRA)*;

solucaoMatching: PALAVRA HIFEN NUMERO (VIRGULA PALAVRA HIFEN NUMERO)*;

solucaoNumerical: NUMERO+;

solucaoShort: ((NEWLINE|WINDOWS_NEWLINE) NUMERO+ HIFEN ( PALAVRA ASTERISCO PALAVRA
                            | ASTERISCO PALAVRA ASTERISCO
                            | ASTERISCO))+;

cotacao: 'Question value: ' NUMERO;

acceptedNumerical: NUMERO+;

solucaoTrueFalse: (TRUE | FALSE);

opcao: opcaoID = PALAVRA PARENTESIS_DIREITO opcaoDescription = frase (NEWLINE|WINDOWS_NEWLINE);

opcaoTrue: TRUE (NEWLINE|WINDOWS_NEWLINE);

opcaoFalse: FALSE (NEWLINE|WINDOWS_NEWLINE);

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

