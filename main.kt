import java.lang.Math.pow
import java.lang.Math.random

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false
    val karma = (pow(random(),(110-healthPoints)/100.0)*20).toInt()
    //Aura
   // val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = auraColor(karma)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    printPlayerStatus(healthPoints, karma, auraColor, isBlessed, name, healthStatus)

    drunkennes(x=castFireBall(12))
}

private fun printPlayerStatus(
    healthPoints: Int,
    karma: Int,
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
){
    val statusFormatString = "(健康指數: $healthPoints)(karma: $karma ，光環: $auraColor) (運勢: ${if (isBlessed) "走運" else "很背"}) -> $name $healthStatus"

    println(statusFormatString)
}

private fun auraColor(karma: Int) =
    when (karma) {
        in (0..5) -> "紅色"
        in (6..10) -> "橘色"
        in (11..15) -> "紫色"
        in (16..20) -> "綠色"
        else -> "無光環"
    }

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "健康狀態極佳"
        in 90..99 -> "有一些小擦傷"
        in 75..89 -> if (isBlessed) {
            "雖有一些傷口，但恢復很快"
        } else {
            "有一些傷口"
        }
        in 15..74 -> "嚴重受傷"
        //顯示玩家狀態
        else -> "情況不妙"
    }
private fun castFireBall(numFireballs: Int = 2): Int {
    print("FireBall杯數(x$numFireballs)")
    return numFireballs
}

private fun drunkennes(x: Int){
    val s= when (x) {
        in 41..50 -> "爛醉如泥"
        in 31..40 -> "大醉"
        in 21..30 -> "醉了"
        in 11..20 -> "微醉"
        in 1..10 -> "微醺"
        0 -> "未喝酒"
        else -> "超出範圍"
    }
    println("醉酒程度: $s")
}