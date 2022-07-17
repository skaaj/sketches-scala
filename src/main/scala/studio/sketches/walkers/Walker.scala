package studio.sketches.walkers

case class Walker(x: Int, y: Int, direction: Int, grid: Grid) {
  def move(dx: Int, dy: Int): Option[Walker] = {
    val newX = x + dx
    val newY = y + dy
    if isInside(newX, newY) then Some(copy(newX, newY)) else None
  }

  def walk(): Option[Walker] = {
    move(1 * direction, 0)
  }

  def turn(): Option[Walker] = {
    move(0, 1).map(_.copy(direction = direction * -1))
  }

  def block(): Walker = {
    copy(direction = 0)
  }

  def isBlocked: Boolean = {
    direction == 0
  }

  private def isInside(x: Int, y: Int): Boolean =
    x >= 0 && x < grid.width && y >= 0 && y < grid.height
}

