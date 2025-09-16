# Text Analysis Toolkit (Java)

A lightweight Java project for analyzing text documents and computing word frequencies.  
Includes classes for word counting, frequency tracking, and term frequency analysis, with full JUnit test coverage.

---

##  Features

### HashDocument
- Store a document with a **title** and **content**.
- Automatically process text into lowercase words (ignores punctuation).
- Word statistics:
  - `frequency(word)` → Get frequency of a word.
  - `contains(word)` → Check if word exists in document.
  - `numUniqueWordsInTable()` → Count unique words.
  - `totalNumOfWords()` → Count total words (including repeats).
  - `mostCommonWord()` → Get the most frequent word.
  - `termFrequency(word)` → Compute **TF** score.

### WordFrequency
- Store a word and its occurrence count.
- Increment count dynamically.
- Compare two `WordFrequency` objects (`Comparable`):
  - Alphabetically by word.
  - By count if words match.

---

## 👾 Testing
JUnit tests are provided for both classes:
- `HashDocumentTest` → Validates word processing, frequency counts, existence checks, and statistics.
- `WordFrequencyTest` → Tests getters, incrementing counts, and comparisons.

---


javac *.java
