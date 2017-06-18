/**
 * Created by yangqc on 2017/6/15.
 */
function expressionCalculate(expression, calculateJsonStr) {
    var valueJson = eval("(" + calculateJsonStr + ")");
    var symbols = ["<", ">", "=", "<=", ">=", "="];
    var valueField;
    //默认表示没有告警
    var result = false;
    for (var i = 0; i < symbols.length; i++) {
        if (expression.indexOf(symbols[i]) > 0) {
            valueField = expression.split(symbols[i])[0];
            break;
        }
    }
    var calculateValue = valueJson[valueField];
    if (calculateValue != null) {
        expression = expression.replace(valueField+"", calculateValue);
        result = eval(expression);
    }
    return result;
}

