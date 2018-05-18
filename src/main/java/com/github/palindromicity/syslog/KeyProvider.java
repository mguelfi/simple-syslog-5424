package com.github.palindromicity.syslog;

import java.util.regex.Pattern;

/**
 * {@code KeyProvider} defines an interface for classes that can be used to provide
 * Map keys used for Syslog 5424 message parts.
 */
public interface KeyProvider {

  /**
   * Provides the key name for the MSG @see <a href="https://tools.ietf.org/html/rfc5424#section-6.4">Section 6.4</a>.
   * @return MSG key name
   */
  String getMessage();

  /**
   * Provides the key name for the HEADER APP-NAME @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.5">Section 6.2.5</a>.
   * @return APP-NAME key name
   */
  String getHeaderAppName();

  /**
   * Provides the key name for the HEADER HOSTNAME @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.4">Section 6.2.4</a>.
   * @return HOSTNAME key name
   */
  String getHeaderHostName();

  /**
   * Provides the key name for the HEADER PRI @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.1">Section 6.2.1</a>.
   * @return PRI key name
   */
  String getHeaderPriority();

  /**
   * Provides the key name for the HEADER PROCID @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.6">Section 6.2.6</a>.
   * @return PROCID key name
   */
  String getHeaderProcessId();

  /**
   * Provides the key name for the HEADER TIMESTAMP @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.3">Section 6.2.3</a>.
   * @return TIMESTAMP key name
   */
  String getHeaderTimeStamp();

  /**
   * Provides the key name for the HEADER MSGID @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.7">Section 6.2.7</a>.
   * @return MSGID key name
   */
  String getHeaderMessageId();

  /**
   * Provides the key name for the HEADER VERSION @see <a href="https://tools.ietf.org/html/rfc5424#section-6.2.2">Section 6.2.2</a>.
   * @return VERSION key name
   */
  String getHeaderVersion();

  /**
   * The base String used for all STRUCTURED_DATA keys.
   * {@code syslog.structuredData. } for example.
   * This can be useful to find all STRUCTURED_DATA keys
   *
   * @see <a href="https://tools.ietf.org/html/rfc5424#section-6.3">Section 6.3</a>
   *
   * @return STRUCTURED_DATA base key name
   */
  String getStructuredBase();

  /**
   * Provides a {@code String.format} {@code String} for producing key name for the STRUCTURED_DATA SD-ID @see <a href="https://tools.ietf.org/html/rfc5424#section-6.3.2">Section 6.3.2</a>.
   *
   * The format {@code String} supports one parameter {@code %s} that will be passed the SD-ID value.
   * The format must begin with the value returned from {@link KeyProvider#getStructuredBase()}
   * For example:
   * <pre>
   *   {@code syslog.structuredData.%s}
   * </pre>
   *
   * @return SD-ID format String
   */
  String getStructuredElementIdFormat();

  /**
   * Provides a {@code String.format} {@code String} for producing key name for the STRUCTURED_DATA SD-PARAM @see <a href="https://tools.ietf.org/html/rfc5424#section-6.3.3">Section 6.3.3</a>.
   *
   * The format {@code String} supports two parameters {@code %s} that will be passed the SD-ID value and
   * the SD-PARAM PARAM-NAME.
   * The format must begin with the value returned from {@link KeyProvider#getStructuredBase()}
   * For example:
   * <pre>
   *   {@code syslog.structuredData.%s.%s}
   * </pre>
   *
   * @return SD-PARAM format String
   */
  String getStructuredElementIdParamNameFormat();

  /**
   * Provides {@code Pattern} that will match and capture the SD-ID and SD-PARAM PARAM-NAME as defined in
   * the return from {@link KeyProvider#getStructuredElementIdParamNameFormat()}.
   * @return {@code Pattern}
   */
  Pattern getStructuredElementIdParamNamePattern();
}