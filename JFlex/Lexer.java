/* The following code was generated by JFlex 1.6.0 */

/* JFlex example: part of Java language lexer specification */
package JFlex;

import java_cup.runtime.*;
import iCCompiler.*;

/**
* This class is a simple example lexer.
*/


public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\16\1\46\1\20"+
    "\2\15\1\51\1\54\1\15\1\57\1\60\1\5\1\47\1\14\1\50"+
    "\1\56\1\4\1\12\11\6\1\15\1\13\1\53\1\45\1\52\2\15"+
    "\32\7\1\61\1\17\1\62\1\15\1\10\1\15\1\25\1\35\1\23"+
    "\1\31\1\27\1\41\1\37\1\43\1\32\1\11\1\44\1\24\1\11"+
    "\1\21\1\34\2\11\1\36\1\26\1\22\1\40\1\33\1\42\1\30"+
    "\2\11\1\63\1\55\1\64\1\15\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff91\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\5\1\10\1\11\1\12\14\7\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\2\1\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\2\1\31\1\32"+
    "\2\12\1\33\13\7\1\34\6\7\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\31\2\0\2\12\1\43\12\7"+
    "\1\44\6\7\1\0\1\2\1\33\1\45\1\46\1\47"+
    "\5\7\1\50\1\7\1\51\5\7\1\52\6\7\1\53"+
    "\1\7\1\54\1\55\1\7\1\56\1\57\1\60\2\7"+
    "\1\61\1\7\1\62\1\63\1\64";

  private static int [] zzUnpackAction() {
    int [] result = new int[136];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\65\0\237\0\65\0\324\0\u0109"+
    "\0\u013e\0\u0173\0\65\0\65\0\65\0\u01a8\0\u01dd\0\u0212"+
    "\0\u0247\0\u027c\0\u02b1\0\u02e6\0\u031b\0\u0350\0\u0385\0\u03ba"+
    "\0\u03ef\0\u0424\0\u0459\0\u048e\0\65\0\65\0\65\0\u04c3"+
    "\0\u04f8\0\u052d\0\u0562\0\65\0\65\0\65\0\65\0\65"+
    "\0\65\0\65\0\u0597\0\u05cc\0\65\0\u0601\0\u0636\0\65"+
    "\0\u066b\0\u06a0\0\u06d5\0\u070a\0\u073f\0\u0774\0\u07a9\0\u07de"+
    "\0\u0813\0\u0848\0\u087d\0\u0173\0\u08b2\0\u08e7\0\u091c\0\u0951"+
    "\0\u0986\0\u09bb\0\65\0\65\0\65\0\65\0\65\0\65"+
    "\0\u09f0\0\u0a25\0\u0a5a\0\u0a8f\0\u0ac4\0\u0173\0\u0af9\0\u0b2e"+
    "\0\u0b63\0\u0b98\0\u0bcd\0\u0c02\0\u0c37\0\u0c6c\0\u0ca1\0\u0cd6"+
    "\0\u0173\0\u0d0b\0\u0d40\0\u0d75\0\u0daa\0\u0ddf\0\u0e14\0\u0e49"+
    "\0\u0a25\0\u0601\0\u0173\0\u0173\0\u0173\0\u0e7e\0\u0eb3\0\u0ee8"+
    "\0\u0f1d\0\u0f52\0\u0173\0\u0f87\0\u0173\0\u0fbc\0\u0ff1\0\u1026"+
    "\0\u105b\0\u1090\0\u0173\0\u10c5\0\u10fa\0\u112f\0\u1164\0\u1199"+
    "\0\u11ce\0\u0173\0\u1203\0\u0173\0\u0173\0\u1238\0\u0173\0\u0173"+
    "\0\u0173\0\u126d\0\u12a2\0\u0173\0\u12d7\0\u0173\0\u0173\0\u0173";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[136];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\2\1\4\1\2\1\16"+
    "\1\17\1\20\1\21\1\22\1\12\1\23\1\24\2\12"+
    "\1\25\1\26\1\12\1\27\1\30\2\12\1\31\1\32"+
    "\2\12\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\67\0\1\4\66\0\1\53\1\54\65\0\1\7"+
    "\3\0\1\7\60\0\5\10\6\0\24\10\26\0\5\55"+
    "\6\0\24\55\26\0\5\12\6\0\24\12\20\0\4\56"+
    "\13\16\1\57\1\60\44\16\6\0\5\12\6\0\6\12"+
    "\1\61\10\12\1\62\4\12\26\0\5\12\6\0\15\12"+
    "\1\63\4\12\1\64\1\12\26\0\5\12\6\0\3\12"+
    "\1\65\7\12\1\66\10\12\26\0\5\12\6\0\6\12"+
    "\1\67\15\12\26\0\5\12\6\0\1\12\1\70\22\12"+
    "\26\0\5\12\6\0\3\12\1\71\3\12\1\72\14\12"+
    "\26\0\5\12\6\0\1\73\17\12\1\74\3\12\26\0"+
    "\5\12\6\0\13\12\1\75\10\12\26\0\5\12\6\0"+
    "\13\12\1\76\1\12\1\77\6\12\26\0\5\12\6\0"+
    "\6\12\1\100\15\12\26\0\5\12\6\0\4\12\1\101"+
    "\17\12\26\0\5\12\6\0\22\12\1\102\1\12\65\0"+
    "\1\103\64\0\1\104\64\0\1\105\64\0\1\106\73\0"+
    "\1\107\65\0\1\110\7\0\1\53\1\3\1\4\62\53"+
    "\4\111\1\112\1\113\57\111\17\56\1\114\1\0\63\56"+
    "\1\115\3\16\42\56\6\0\5\12\6\0\21\12\1\116"+
    "\2\12\26\0\5\12\6\0\3\12\1\117\20\12\26\0"+
    "\5\12\6\0\17\12\1\120\4\12\26\0\5\12\6\0"+
    "\11\12\1\121\12\12\26\0\5\12\6\0\4\12\1\122"+
    "\17\12\26\0\5\12\6\0\1\123\23\12\26\0\5\12"+
    "\6\0\1\124\23\12\26\0\5\12\6\0\4\12\1\125"+
    "\10\12\1\126\6\12\26\0\5\12\6\0\5\12\1\127"+
    "\16\12\26\0\5\12\6\0\1\12\1\130\22\12\26\0"+
    "\5\12\6\0\1\12\1\131\22\12\26\0\5\12\6\0"+
    "\11\12\1\132\12\12\26\0\5\12\6\0\13\12\1\133"+
    "\10\12\26\0\5\12\6\0\6\12\1\134\15\12\26\0"+
    "\5\12\6\0\1\12\1\135\22\12\26\0\5\12\6\0"+
    "\3\12\1\136\20\12\26\0\5\12\6\0\11\12\1\137"+
    "\12\12\20\0\4\111\1\112\1\140\57\111\5\112\1\140"+
    "\63\112\1\141\1\140\57\112\17\56\1\114\51\56\13\16"+
    "\1\57\1\142\44\16\6\0\5\12\6\0\3\12\1\143"+
    "\20\12\26\0\5\12\6\0\6\12\1\144\15\12\26\0"+
    "\5\12\6\0\5\12\1\145\16\12\26\0\5\12\6\0"+
    "\5\12\1\146\16\12\26\0\5\12\6\0\1\12\1\147"+
    "\22\12\26\0\5\12\6\0\16\12\1\150\5\12\26\0"+
    "\5\12\6\0\1\12\1\151\22\12\26\0\5\12\6\0"+
    "\11\12\1\152\12\12\26\0\5\12\6\0\6\12\1\153"+
    "\15\12\26\0\5\12\6\0\6\12\1\154\15\12\26\0"+
    "\5\12\6\0\10\12\1\155\13\12\26\0\5\12\6\0"+
    "\3\12\1\156\20\12\26\0\5\12\6\0\4\12\1\157"+
    "\17\12\26\0\5\12\6\0\17\12\1\160\4\12\26\0"+
    "\5\12\6\0\5\12\1\161\16\12\26\0\5\12\6\0"+
    "\3\12\1\162\20\12\20\0\4\112\1\4\1\140\57\112"+
    "\6\0\5\12\6\0\5\12\1\163\16\12\26\0\5\12"+
    "\6\0\11\12\1\164\12\12\26\0\5\12\6\0\1\12"+
    "\1\165\22\12\26\0\5\12\6\0\11\12\1\166\12\12"+
    "\26\0\5\12\6\0\1\167\23\12\26\0\5\12\6\0"+
    "\1\170\23\12\26\0\5\12\6\0\6\12\1\171\15\12"+
    "\26\0\5\12\6\0\23\12\1\172\26\0\5\12\6\0"+
    "\15\12\1\173\6\12\26\0\5\12\6\0\6\12\1\174"+
    "\15\12\26\0\5\12\6\0\6\12\1\175\15\12\26\0"+
    "\5\12\6\0\1\176\23\12\26\0\5\12\6\0\22\12"+
    "\1\177\1\12\26\0\5\12\6\0\2\12\1\200\21\12"+
    "\26\0\5\12\6\0\16\12\1\201\5\12\26\0\5\12"+
    "\6\0\10\12\1\202\13\12\26\0\5\12\6\0\4\12"+
    "\1\203\17\12\26\0\5\12\6\0\1\204\23\12\26\0"+
    "\5\12\6\0\17\12\1\205\4\12\26\0\5\12\6\0"+
    "\5\12\1\206\16\12\26\0\5\12\6\0\1\207\23\12"+
    "\26\0\5\12\6\0\6\12\1\210\15\12\20\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4876];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\4\1\3\11"+
    "\17\1\3\11\4\1\7\11\2\1\1\11\2\1\1\11"+
    "\22\1\6\11\1\1\2\0\24\1\1\0\50\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[136];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	private Token symbol(int type, String tag, String value) {
		return new Token(type, tag, yyline, yycolumn, value);
	}
	
	private void lexError(String message) throws LexicalError {
		throw new LexicalError(message, yyline+1, yycolumn+1);
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 164) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws LexicalError {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new LexicalError(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws LexicalError {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token next_token() throws java.io.IOException, LexicalError {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { lexError("invalid character '"+ yytext()+"'");
          }
        case 53: break;
        case 2: 
          { /* ignore */
          }
        case 54: break;
        case 3: 
          { return symbol(sym.DIVIDE, "/", yytext());
          }
        case 55: break;
        case 4: 
          { return symbol(sym.MULTIPLY, "*", yytext());
          }
        case 56: break;
        case 5: 
          { return symbol(sym.NUM, "INTEGER", yytext());
          }
        case 57: break;
        case 6: 
          { return symbol(sym.CLASS_ID, "CLASS_ID", yytext());
          }
        case 58: break;
        case 7: 
          { return symbol(sym.ID, "ID", yytext());
          }
        case 59: break;
        case 8: 
          { return symbol(sym.SEMI, ";", yytext());
          }
        case 60: break;
        case 9: 
          { return symbol(sym.COMMA, ",", yytext());
          }
        case 61: break;
        case 10: 
          { lexError("malformed string literal");
          }
        case 62: break;
        case 11: 
          { return symbol(sym.EQ, "=", yytext());
          }
        case 63: break;
        case 12: 
          { return symbol(sym.NEGATION, "!", yytext());
          }
        case 64: break;
        case 13: 
          { return symbol(sym.PLUS, "+", yytext());
          }
        case 65: break;
        case 14: 
          { return symbol(sym.MINUS, "-", yytext());
          }
        case 66: break;
        case 15: 
          { return symbol(sym.REMINDER, "%", yytext());
          }
        case 67: break;
        case 16: 
          { return symbol(sym.BIG, ">", yytext());
          }
        case 68: break;
        case 17: 
          { return symbol(sym.SMALL, "<", yytext());
          }
        case 69: break;
        case 18: 
          { return symbol(sym.DOT, ".", yytext());
          }
        case 70: break;
        case 19: 
          { return symbol(sym.OPENROUNDPARENTEHSIS, "(", yytext());
          }
        case 71: break;
        case 20: 
          { return symbol(sym.CLOSEROUNDPARENTHESIS, ")", yytext());
          }
        case 72: break;
        case 21: 
          { return symbol(sym.OPENSQUAREPARENTEHSIS, "[", yytext());
          }
        case 73: break;
        case 22: 
          { return symbol(sym.CLOSESQUAREPARENTHESIS, "]", yytext());
          }
        case 74: break;
        case 23: 
          { return symbol(sym.OPENCURLYPARENTEHSIS, "{", yytext());
          }
        case 75: break;
        case 24: 
          { return symbol(sym.CLOSECURLYPARENTHESIS, "}", yytext());
          }
        case 76: break;
        case 25: 
          { lexError("unterminated comment");
          }
        case 77: break;
        case 26: 
          { lexError("an identifier cannot start with '_'");
          }
        case 78: break;
        case 27: 
          { return symbol(sym.STR, "STRING", yytext());
          }
        case 79: break;
        case 28: 
          { return symbol(sym.IF, "if", yytext());
          }
        case 80: break;
        case 29: 
          { return symbol(sym.EQCOMP, "==", yytext());
          }
        case 81: break;
        case 30: 
          { return symbol(sym.NOTEQCOMP, "!=", yytext());
          }
        case 82: break;
        case 31: 
          { return symbol(sym.BIGEQ, ">=", yytext());
          }
        case 83: break;
        case 32: 
          { return symbol(sym.SMALLEQ, "<=", yytext());
          }
        case 84: break;
        case 33: 
          { return symbol(sym.AND, "&&", yytext());
          }
        case 85: break;
        case 34: 
          { return symbol(sym.OR, "||", yytext());
          }
        case 86: break;
        case 35: 
          { return symbol(sym.NEW, "new", yytext());
          }
        case 87: break;
        case 36: 
          { return symbol(sym.INT, "int", yytext());
          }
        case 88: break;
        case 37: 
          { return symbol(sym.NULL, "null", yytext());
          }
        case 89: break;
        case 38: 
          { return symbol(sym.TRUE, "true", yytext());
          }
        case 90: break;
        case 39: 
          { return symbol(sym.THIS, "this", yytext());
          }
        case 91: break;
        case 40: 
          { return symbol(sym.ELSE, "else", yytext());
          }
        case 92: break;
        case 41: 
          { return symbol(sym.VOID, "void", yytext());
          }
        case 93: break;
        case 42: 
          { return symbol(sym.CLASS, "class", yytext());
          }
        case 94: break;
        case 43: 
          { return symbol(sym.BREAK, "break", yytext());
          }
        case 95: break;
        case 44: 
          { return symbol(sym.FALSE, "false", yytext());
          }
        case 96: break;
        case 45: 
          { return symbol(sym.WHILE, "while", yytext());
          }
        case 97: break;
        case 46: 
          { return symbol(sym.LENGTH, "length", yytext());
          }
        case 98: break;
        case 47: 
          { return symbol(sym.STATIC, "static", yytext());
          }
        case 99: break;
        case 48: 
          { return symbol(sym.STRING, "string", yytext());
          }
        case 100: break;
        case 49: 
          { return symbol(sym.RETURN, "return", yytext());
          }
        case 101: break;
        case 50: 
          { return symbol(sym.EXTENDS, "extends", yytext());
          }
        case 102: break;
        case 51: 
          { return symbol(sym.BOOLEAN, "boolean", yytext());
          }
        case 103: break;
        case 52: 
          { return symbol(sym.CONTINUE, "continue", yytext());
          }
        case 104: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {   	return symbol(sym.EOF, "EOF", "EOF");
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
