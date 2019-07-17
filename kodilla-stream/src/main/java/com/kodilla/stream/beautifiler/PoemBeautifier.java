package com.kodilla.stream.beautifiler;

public class PoemBeautifier {
    public void beatify(String textToDecorate, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(textToDecorate);
        System.out.println(result);
    }
}
