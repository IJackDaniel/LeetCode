import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _TaskFileCreator {
    // Константы для сложности
    private static final String EASY = "Easy";
    private static final String MEDIUM = "Medium";
    private static final String HARD = "Hard";

    // Множество ключевых слов Java для быстрой проверки
    private static final Set<String> JAVA_KEYWORDS = new HashSet<>();

    static {
        String[] keywords = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch",
                "char", "class", "const", "continue", "default", "do", "double",
                "else", "enum", "extends", "final", "finally", "float", "for",
                "goto", "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static", "strictfp",
                "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while", "true", "false", "null"
        };
        for (String keyword : keywords) {
            JAVA_KEYWORDS.add(keyword.toLowerCase());
        }
    }

    /**
     * Класс для хранения информации о сигнатуре функции
     */
    static class FunctionSignature {
        String name;
        String returnType;
        String parameters;

        FunctionSignature(String name, String returnType, String parameters) {
            this.name = name;
            this.returnType = returnType;
            this.parameters = parameters;
        }

        /**
         * Возвращает тип по умолчанию для тестовых вызовов
         */
        String getDefaultReturnValue() {
            // Проверяем, является ли тип массивом
            if (returnType.endsWith("[]")) {
                String baseType = returnType.substring(0, returnType.length() - 2);
                switch (baseType.toLowerCase()) {
                    case "int":
                    case "integer":
                        return "new int[0]";
                    case "string":
                        return "new String[0]";
                    case "double":
                        return "new double[0]";
                    case "float":
                        return "new float[0]";
                    case "long":
                        return "new long[0]";
                    case "char":
                        return "new char[0]";
                    case "boolean":
                        return "new boolean[0]";
                    case "byte":
                        return "new byte[0]";
                    case "short":
                        return "new short[0]";
                    default:
                        return "null";
                }
            }

            // Обычные типы
            switch (returnType.toLowerCase()) {
                case "int":
                case "integer":
                    return "0";
                case "double":
                    return "0.0";
                case "float":
                    return "0.0f";
                case "boolean":
                    return "false";
                case "char":
                    return "'\\0'";
                case "string":
                    return "\"\"";
                case "long":
                    return "0L";
                case "byte":
                    return "(byte)0";
                case "short":
                    return "(short)0";
                case "void":
                    return "";
                default:
                    return "null";
            }
        }

        /**
         * Получает тип переменной result (с поддержкой массивов)
         */
        String getResultType() {
            return returnType;
        }

        @Override
        public String toString() {
            return "static " + returnType + " " + name + "(" + parameters + ")";
        }
    }

    /**
     * Парсит строку с сигнатурой функции
     */
    private static FunctionSignature parseFunctionSignature(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Function signature cannot be empty");
        }

        String signature = input.trim();

        // Удаляем фигурную скобку в конце, если есть
        if (signature.endsWith("{")) {
            signature = signature.substring(0, signature.length() - 1).trim();
        }

        // Удаляем модификаторы доступа (public, private, protected)
        signature = signature.replaceAll("^(public|private|protected|static)\\s+", "");

        // Улучшенное регулярное выражение для парсинга сигнатуры
        // Поддерживает массивы (int[], String[], и т.д.)
        // Группы: 1 - возвращаемый тип, 2 - имя функции, 3 - параметры
        Pattern pattern = Pattern.compile(
                "^([\\w<>\\[\\]]+)\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*$"
        );

        Matcher matcher = pattern.matcher(signature);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    "Invalid function signature format. Expected: 'returnType functionName(params)'\n" +
                            "Examples:\n" +
                            "  - String mergeAlternately(String word1, String word2)\n" +
                            "  - int[] twoSum(int[] nums, int target)\n" +
                            "  - List<String> generateParenthesis(int n)"
            );
        }

        String returnType = matcher.group(1).trim();
        String functionName = matcher.group(2).trim();
        String parameters = matcher.group(3).trim();

        // Валидация имени функции
        if (!isValidIdentifier(functionName)) {
            throw new IllegalArgumentException("Invalid function name: " + functionName);
        }

        // Валидация типов (опциональная)
        if (!isValidType(returnType)) {
            System.err.println("Warning: Return type '" + returnType + "' may not be standard Java type");
        }

        // Валидация параметров
        if (!parameters.isEmpty()) {
            String[] paramPairs = parameters.split("\\s*,\\s*");
            for (String pair : paramPairs) {
                String[] parts = pair.trim().split("\\s+", 2);
                if (parts.length < 2) {
                    throw new IllegalArgumentException(
                            "Invalid parameter format: '" + pair + "'. Expected: 'type name'"
                    );
                }
                String paramType = parts[0];
                if (!isValidType(paramType)) {
                    System.err.println("Warning: Parameter type '" + paramType + "' may not be standard Java type");
                }
            }
        }

        return new FunctionSignature(functionName, returnType, parameters);
    }

    /**
     * Простая проверка, что тип выглядит валидно
     */
    private static boolean isValidType(String type) {
        if (type == null || type.isEmpty()) {
            return false;
        }

        // Проверяем базовые типы
        String[] basicTypes = {
                "int", "double", "float", "boolean", "char", "String", "long",
                "byte", "short", "void", "Integer", "Double", "Float", "Boolean",
                "Character", "Long", "Byte", "Short"
        };

        // Проверяем, не заканчивается ли на [] (массив)
        if (type.endsWith("[]")) {
            String baseType = type.substring(0, type.length() - 2);
            for (String basicType : basicTypes) {
                if (basicType.equalsIgnoreCase(baseType)) {
                    return true;
                }
            }
            // Проверяем другие типы массивов
            return baseType.matches("[a-zA-Z_$][a-zA-Z0-9_$]*");
        }

        // Проверяем обычные типы
        for (String basicType : basicTypes) {
            if (basicType.equalsIgnoreCase(type)) {
                return true;
            }
        }

        // Разрешаем дженерики (например, List<String>)
        if (type.contains("<") && type.contains(">")) {
            return true;
        }

        // Разрешаем другие пользовательские типы
        return type.matches("[a-zA-Z_$][a-zA-Z0-9_$<>,\\s]*");
    }

    /**
     * Валидация идентификатора (имени функции или класса)
     */
    private static boolean isValidIdentifier(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        String trimmed = name.trim();

        if (!Character.isJavaIdentifierStart(trimmed.charAt(0))) {
            return false;
        }

        for (int i = 1; i < trimmed.length(); i++) {
            if (!Character.isJavaIdentifierPart(trimmed.charAt(i))) {
                return false;
            }
        }

        return !JAVA_KEYWORDS.contains(trimmed.toLowerCase());
    }

    /**
     * Конвертирует строку в CamelCase
     */
    private static String toCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (result.length() == 0 || capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            } else if (c == ' ' || c == '-' || c == '_') {
                capitalizeNext = true;
            }
        }

        return result.toString();
    }

    /**
     * Создает корректное имя класса из пользовательского ввода
     */
    private static String createClassName(String userInput) {
        String cleaned = userInput.replaceAll("['\"]", "");
        String className = toCamelCase(cleaned);

        if (className == null || className.isEmpty()) {
            throw new IllegalArgumentException("Cannot create class name from input: " + userInput);
        }

        validateClassName(className);

        if (!Character.isUpperCase(className.charAt(0))) {
            className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
        }

        return className;
    }

    /**
     * Валидация имени класса
     */
    private static void validateClassName(String className) {
        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("Class name cannot be empty");
        }

        char firstChar = className.charAt(0);
        if (!Character.isJavaIdentifierStart(firstChar)) {
            throw new IllegalArgumentException(
                    String.format("Class name must start with a letter, $ or _. Got: '%c'", firstChar)
            );
        }

        for (int i = 1; i < className.length(); i++) {
            char c = className.charAt(i);
            if (!Character.isJavaIdentifierPart(c)) {
                throw new IllegalArgumentException(
                        String.format("Invalid character in class name: '%c'", c)
                );
            }
        }

        if (JAVA_KEYWORDS.contains(className.toLowerCase())) {
            throw new IllegalArgumentException(
                    String.format("'%s' is a Java reserved word", className)
            );
        }
    }

    /**
     * Получение сложности задачи
     */
    private static String getDifficulty(int choice) {
        return switch (choice) {
            case 1 -> EASY;
            case 2 -> MEDIUM;
            case 3 -> HARD;
            default -> throw new IllegalArgumentException("Invalid difficulty choice: " + choice);
        };
    }

    /**
     * Создание содержимого файла с учетом сигнатуры функции
     */
    private static String createFileContent(
            String originalTaskName,
            String className,
            FunctionSignature signature,
            int taskNumber,
            String difficulty) {

        // Определяем тип переменной result
        String resultType = signature.getResultType();

        return String.format(
                "// Task name: %d. %s\n" +
                        "// Difficulty: %s\n" +
                        "// Status: Unsolved\n" +
                        "// Date of creation: %s\n" +
                        "\n" +
                        "public class %s {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        %s result = %s();\n" +
                        "        System.out.println(result);\n" +
                        "        result = %s();\n" +
                        "        System.out.println(result);\n" +
                        "    }\n" +
                        "\n" +
                        "    %s {\n" +
                        "        return %s;\n" +
                        "    }\n" +
                        "}\n",
                taskNumber,
                originalTaskName,
                difficulty,
                LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                className,
                resultType,
                signature.name,
                signature.name,
                signature.toString(),
                signature.getDefaultReturnValue()
        );
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Task File Creator ===");

            // Ввод названия задачи
            System.out.print("Enter task name: ");
            String originalTaskName = scanner.nextLine().trim();

            if (originalTaskName.isEmpty()) {
                System.err.println("Error: Task name cannot be empty");
                return;
            }

            // Создание имени класса
            String className;
            try {
                className = createClassName(originalTaskName);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                return;
            }

            // Ввод сигнатуры функции
            System.out.print("Enter function signature: ");
            String signatureInput = scanner.nextLine().trim();

            FunctionSignature signature;
            try {
                signature = parseFunctionSignature(signatureInput);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                return;
            }

            // Ввод номера задачи
            int taskNumber;
            while (true) {
                System.out.print("Enter number of task: ");
                if (scanner.hasNextInt()) {
                    taskNumber = scanner.nextInt();
                    if (taskNumber > 0) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Please enter a positive integer");
            }

            // Ввод сложности
            System.out.print("Enter difficulty:\nEasy - 1\nMedium - 2\nHard - 3\ndifficulty: ");

            int difficultyChoice;
            while (true) {
                if (scanner.hasNextInt()) {
                    difficultyChoice = scanner.nextInt();
                    if (difficultyChoice >= 1 && difficultyChoice <= 3) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.print("Please enter 1, 2, or 3: ");
            }

            // Получение сложности
            String difficulty = getDifficulty(difficultyChoice);

            // Создание содержимого файла
            String fileContent = createFileContent(
                    originalTaskName,
                    className,
                    signature,
                    taskNumber,
                    difficulty
            );

            // Создаем файл в текущей директории (там же, где и эта программа)
            String fileName = className + ".java";
            Path currentDir = Paths.get("").toAbsolutePath();
            Path filePath = currentDir.resolve(fileName);

            try {
                Files.writeString(filePath, fileContent);
                System.out.println("\n✓ Java class created successfully: " + filePath.getFileName());
                System.out.println("✓ Location: " + currentDir);
                System.out.println("✓ Task: " + taskNumber + ". " + originalTaskName);
                System.out.println("✓ Function: " + signature.toString());
                System.out.println("✓ Difficulty: " + difficulty);

            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}