# [Kotlin Note](../../README.md) - Chapter 13 Special Topics
| Chapter | Title |
| :-: | :- |
| 13.1 | [Characters](#131-characters) |
|  | [Escape Characters](#escape-characters) |
|  | [Invisible Characters](#invisible-characters) |
|  | [Special Characters](#special-characters) |

<br>

## 13.1 Characters
### Escape Characters
- The <, >, &, ", and ' characters have special syntax meaning in HTML, and may be misinterpreted as code. Therefore, the W3C recommends that you escape <, >, and & characters in content.

| Character | Description | Entity name | Decimal no. | Hexadecimal no. |
| :-- | :-- | :-- | :-- | :-- |
| < | Less-than symbol | \&lt; | \&#060; | \&#x3C; |
| > | Greater-than symbol | \&gt; | \&#062; | \&#x3E; |
| " | Quotation mark | \&quot; | \&#034; | \&#x22; |
| ' | Apostrophe | \&apos; | \&#039; | \&#x27; |
| & | Ampersand | \&amp; | \&#038; | \&#x26; |

### Invisible Characters
| Character | Description | Entity name | Decimal no. | Hexadecimal no. |
| :-- | :-- | :-- | :-- | :-- |
| (non-printing) | Non-breaking space | \&nbsp; | \&#160; | \&#xA0; |
| (non-printing) | En space | \&ensp; | \&#8194; | \&#x2002; |
| (non-printing) | Em space | \&emsp; | \&#8195; | \&#x2003; |
| (non-printing) | Zero-width space | (none) | \&#8203; | \&#x200B; |
| (non-printing) | Zero-width non-joiner | \&zwnj; | \&#8204; | \&#x200C; |
| (non-printing) | Zero-width joiner | \&zwj; | \&#8205; | \&#x200D; |

### Special Characters
| Character | Description | Entity name | Decimal no. | Hexadecimal no. |
| :-- | :-- | :-- | :-- | :-- |
| ‘ | Left curly single quote | \&lsquo; | \&#8216; | \&#x2018; |
| ’ | Right curly single quote | \&rsquo; | \&#8217; | \&#x2019; |
| “ | Left curly double quote | \&ldquo; | \&#8220; | \&#x201C; |
| ” | Right curly double quote | \&rdquo; | \&#8221; | \&#x201D; |
| ... | Horizontal ellipsis | \&hellip; | \&#8230; | \&#x2026; |
| © | Copyright | \&copy; | \&#169; | \&#xA9; |
| ® | Registered trademark | \&reg; | \&#174; | \&#xAE; |
| ™ | Trademark | \&trade; | \&#8482; | \&#x2026; |
| £ | Pound | \&pound; | \&#163; | \&#xA3; |
| ¥ | Yen | \&yen; | \&#165; | \&#xA5; |
| € | Euro | \&euro; | \&#8364; | \&#x20AC; |
| – | En dash | \&ndash; | \&#8211; | \&#x2013; |
| — | Em dash | \&mdash; | \&#8212; | \&#x2014; |

<br>
