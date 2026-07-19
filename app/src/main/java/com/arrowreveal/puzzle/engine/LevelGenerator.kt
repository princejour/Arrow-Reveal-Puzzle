private fun directionForCell(

    row: Int,

    column: Int

): Direction {


    return when {


        // الحواف تخرج للخارج
        row == 0 ->
            Direction.UP


        row == 4 ->
            Direction.DOWN


        column == 0 ->
            Direction.LEFT


        column == 4 ->
            Direction.RIGHT



        // داخل الشكل:
        // توزيع اتجاهات يخلق مسارات مختلفة

        (row + column) % 4 == 0 ->
            Direction.UP


        (row + column) % 4 == 1 ->
            Direction.RIGHT


        (row + column) % 4 == 2 ->
            Direction.DOWN


        else ->
            Direction.LEFT

    }

}
