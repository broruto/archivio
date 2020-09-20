package common;

public class StatusCode {

//1xx Informational
	//Il server ha ricevuto l'header della richiesta e il client deve procedere ad inviare il corpo della richiesta (solitamente nelle richieste di tipo POST).
	public static final Integer CONTINUE = 100;
	
	//Il richiedente ha richiesto di cambiare il protocollo in uso e il server è a conoscenza di ciò che dovrà fare.
	public static final Integer SWITCHING_PROTOCOLS = 101;
	
	//Questo codice indica che il server ha ricevuto e sta processando la richiesta, ma non ha ancora una risposta disponibile. È utilizzato questo codice per evitare che il client vada in timeout mentre aspetta la risposta.
	public static final Integer PROCESSING = 102;
	
//2xx Success
	//Risposta standard per le richieste HTTP andate a buon fine.
	public static final Integer OK = 200;
	
	//La richiesta è stata soddisfatta, restituendo la creazione di una nuova risorsa.
	public static final Integer CREATED = 201;
	
	//La richiesta di elaborazione è stata accettata ma non è ancora terminata.
	public static final Integer ACCEPTED = 202;
	
	//Il server è un transforming proxy (ad es. un Web Accelerator) che ha ricevuto un 200 OK dalla sua origine, ma sta restituendo una versione modificata della risposta dell'origine
	public static final Integer NON_AUTHORITATIVE_INFORMATION = 203;
	
	//Il server ha processato con successo la richiesta e non restituirà nessun contenuto.
	public static final Integer NO_CONTENT = 204;
	
	//Il server ha processato con successo la richiesta e non restituirà nessun contenuto. Al contrario della risposta 204, questa richiede che il richiedente resetti il document view.
	public static final Integer RESET_CONTENT = 205;
	
	//Il server sta consegnando solo parti della risorsa (byte serving) a causa del range di un header inviato dal client. Il range heaeder è usato dai client HTTP per abilitare il ripristino di download interrotti, o per frazionare un download in molteplici flussi simultanei.
	public static final Integer PARTIAL_CONTENT = 206;
	
	//In caso di risposte XML, quando più azioni possono essere richieste, i dettagli dei singoli stati sono dati nel corpo della risposta. Vedi WebDAV (RFC 4918) per le specifiche associate.
	public static final Integer MULTI_STATUS = 207;
	
	//Utilizzato all'interno di un elemento di risposta DAV: propstat per evitare di enumerare ripetutamente i membri interni di più collegamenti alla stessa raccolta.
	public static final Integer ALREADY_REPORTED = 208;
	
//3xx Redirezione
	//ndica opzioni multiple per la risorse tra cui il client potrebbe scegliere (tramite una negoziazione di contenuto agent-driven). Per esempio, questo codice potrebbe essere usato per presentare più opzioni di formati video, per elencare file con estensioni diverse, o per suggerire una disambiguazione.
	public static final Integer MULTIPLE_CHOICES = 300;
	
	//Questa e tutte le future richieste andranno dirette ad un altro URI (specificato nell'header Location).
	public static final Integer MOVED_PERMANENTLY = 301;
	
	//Questo è il codice più usato ma anche un classico esempio di non aderenza agli standard nella pratica quotidiana. Infatti, le specifiche di HTTP/1.0 (RFC 1945) richiederebbero che il client esegua redirezioni temporanee (la descrizione originale era "Moved Temporarily"), ma i più diffusi browser l'hanno implementata come 303 descritta di seguito. Perciò, HTTP/1.1 ha aggiunto i codici di stato 303 e 307 per distinguere tra i due comportamenti. Comunque, la maggior parte delle applicazioni e dei framework web ancora usano il codice di stato 302 come se fosse il 303.
	public static final Integer FOUND = 302;
	
	//La risposta alla richiesta può essere trovata sotto un'altra URI usando il metodo GET.
	public static final Integer SEE_OTHER = 303;
	
	//Indica che la risorsa non è stata modificata a causa della versione specificata dagli header di richiesta If-Modified-Since o If-None-Match. In questo caso, non c'è bisogno di ritrasmettere la singola risorsa perché il client dispone di una copia già precedentemente scaricata.
	public static final Integer NOT_MODIFIED = 304;
	
	//La risorsa richiesta è disponibile solo passando da un proxy, il cui indirizzo viene fornito nella risposta. Per motivi di sicurezza, molti client HTTP (come Mozilla ed Internet Explorer) non gestiscono correttamente le risposte con questo codice di stato.
	public static final Integer USE_PROXY = 305;
	
	//Non più usato. Originariamente significava "Le richieste successive dovrebbero usare il proxy specificato".
	public static final Integer SWITCH_PROXY = 306;
	
	//In quest'occasione, la richiesta dovrebbe essere ripetuta con un'altra URI, ma successive richieste possono essere ancora dirette a quella originale. In contrasto con 303, la richiesta di POST originale deve essere reiterata con un'altra richiesta di tipo POST.
	public static final Integer TEMPORARY_REDIRECT = 307;
	
	//Questa richiesta e le future dovrebbero essere fatte verso un altro URI. Le risposte 307 e 308 (come proposta) dovrebbero comportarsi similmente alla 302 e la 301, ma non prevedono un cambiamento di metodo.
	public static final Integer PERMANENT_REDIRECT = 308;

//4xx Client Error
	//La richiesta non può essere soddisfatta a causa di errori di sintassi.
	public static final Integer BAD_REQUEST = 400;
	
	//Simile a 403/Forbidden, ma pensato per essere usato quando l'autenticazione è possibile ma è fallita o non può essere fornita. Vedi anche basic access authentication e digest access authentication.
	public static final Integer UNAUTHORIZED = 401;
	
	//L'intendimento originale prevedeva un suo utilizzo per realizzare meccanismi di digital cash/micropagamento, ma questo non si è mai verificato ed il codice non è mai stato utilizzato.
	public static final Integer PAYMENT_REQUIRED = 402;
	
	//La richiesta è legittima ma il server si rifiuta di soddisfarla. Contrariamente al codice 401 Unauthorized, l'autenticazione non ha effetto.
	public static final Integer FORBIDDEN = 403;
	
	//La risorsa richiesta non è stata trovata ma in futuro potrebbe essere disponibile.
	public static final Integer NOT_FOUND = 404;
	
	//La richiesta è stata eseguita usando un metodo non permesso. Ad esempio questo accade quando si usa il metodo GET per inviare dati da presentare con un metodo POST.
	public static final Integer METHOD_NOT_ALLOWED = 405;
	
	//La risorsa richiesta è solo in grado di generare contenuti non accettabili secondo la header Accept inviato nella richiesta.
	public static final Integer NOT_ACCEPTABLE = 406;
	
	//Per proseguire, il client deve autenticarsi sul proxy.
	public static final Integer PROXY_AUTHENTICATION_REQUIRED = 407;
	
	//Il tempo per inviare la richiesta è scaduto e il server ha terminato la connessione.
	public static final Integer REQUEST_TIMEOUT = 408;
	
	//La richiesta non può essere portata a termine a causa di un conflitto con lo stato attuale della risorsa.
	//Questo codice è permesso solo nei casi in cui ci si aspetta che l'utente possa risolvere il conflitto e ripetere la richiesta.
	//Il corpo della risposta dovrebbe contenere abbastanza informazioni per individuare la causa del conflitto.
	public static final Integer CONFLICT = 409;
	
	//Indica che la risorsa richiesta non è più disponibile e non lo sarà più in futuro.
	public static final Integer GONE = 410;
	
	//La richiesta non specifica la propria dimensione come richiesto dalla risorsa richiesta.
	public static final Integer LENGTH_REQUIRED = 411;
	
	//Il server non soddisfa una delle precondizioni che il richiedente ha inserito nella richiesta.
	public static final Integer PRECONDITION_FAILED = 412;
	
	//La richiesta è più grande di quanto il server possa gestire.
	public static final Integer REQUEST_ENTITY_TOO_LARGE = 413;
	
	//L'URI richiesto è troppo grande per essere elaborato dal server.
	public static final Integer REQUEST_URI_TOO_LONG = 414;
	
	//L'entità della richiesta è di un tipo non accettato dal server o dalla risorsa richiesta.
	public static final Integer UNSUPPORTED_MEDIA_TYPE = 415;
	
	//Il client ha richiesto un frammento di un file, ma il server non riesce a restituire quel frammento.
	public static final Integer REQUESTED_RANGE_NOT_SATISFIABLE = 416;
	
	//Il server non rispetta i requisiti del campo header di una richiesta Expect.
	public static final Integer EXPECTATION_FAILED = 417;
	
	//Questo è un tipico pesce d'aprile dell'IETF.[4] Solitamente non viene mai implementato in nessun server HTTP. L'RFC specifica che questo codice di stato dovrebbe essere restituito dalle teiere a cui viene erroneamente richiesto di preparare del caffè. Questo stato viene utilizzato come easter egg in alcuni siti, come Google.
	public static final Integer PESCE_DAPRILE = 418;
	
	//Restituito dalle Twitter Search e Trends API Quando il client è rate-limited, ovvero quando viene definito un numero massimo di chiamate verso le API in un breve tempo stabilito.
	public static final Integer ENHANCE_YOUR_CALM = 420;
	
	//Il server comprende il tipo di contenuto dell'entità richiesta e la sintassi della richiesta è corretta, ma non è in grado di processare le istruzioni contenute nella richiesta.
	public static final Integer UNPROCESSABLE_ENTITY = 422;
	
	//Il client dovrebbe cambiare il protocollo ed usare ad esempio il TLS/1.0.
	public static final Integer UPGRADE_REQUIRED = 426;
	
	//Il client ha effettuato troppe richieste in un intervallo di tempo ridotto. Destinato all'uso con schemi di limitazione della velocità (rate-limiting schemes).
	public static final Integer TOO_MANY_REQUESTS = 429;
	
	//Estensione di Microsoft: The request should be retried after doing the appropriate action.
	public static final Integer RETRY_WITH = 449;
	
	//Stato non obbligatorio utilizzato quando l'accesso alla risorsa è limitato per ragioni legali come censura o mandati governativi. Probabilmente fa riferimento al romanzo distopico Fahrenheit 451.
	public static final Integer UNAVAILABLE_FOR_LEGAL_REASONS = 451;//(Approvato da Internet Engineering Steering Group IESG)
	
//5xx Server Error
	//Messaggio di errore generico senza alcun dettaglio.
	public static final Integer INTERNAL_ERROR = 500;
	
	//Il server non è in grado di soddisfare il metodo della richiesta.
	public static final Integer NOT_IMPLEMENTED = 501;
	
	//Il server si sta comportando come un gateway o un proxy e ha ricevuto una risposta invalida dal server di upstream.
	public static final Integer BAD_GATEWAY = 502;
	
	//Il server non è al momento disponibile. Generalmente è una condizione temporanea.
	public static final Integer SERVICE_UNAVAIABLE = 503;
	
	//Il server si sta comportando come un gateway o un proxy e non ha ricevuto una risposta tempestiva dal server di upstream.
	public static final Integer GATEWAY_TIMEOUT = 504;
	
	//Il server non supporta la versione HTTP della richiesta.
	public static final Integer HTTP_VERSION_NOT_SUPPORTED = 505;
	
	//Questo codice di stato, benché usato da molti server, non è un codice di stato ufficiale in quanto non è specificato in alcuna RFC.
	public static final Integer BANDWIDTH_LIMIT_EXCEEDED = 509;
	
}
