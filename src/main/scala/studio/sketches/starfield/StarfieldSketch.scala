package studio.sketches.starfield

import processing.core.PApplet.map
import processing.core.PConstants.*
import studio.sketches.Sketch
import studio.sketches.starfield.Star

class StarfieldSketch extends Sketch {
  val NB_STARS = 30_000
  val stars =
    for i <- (0 until NB_STARS)
    yield
      Star(random(-width, width), random(-height, height), random(width))

  override def settings(): Unit = {
    size(1024, 768)
  }

  override def draw(): Unit = {
    background(0)
    translate(width / 2, height / 2)

    println(frameRate)

      for star <- stars
      do
          updateStar(star, 20)
          drawStar(star)
  }

  private def updateStar(s: Star, speed: Float): Unit = {
    s.z -= speed
    if s.z <= 0 then
      s.x = random(-width, width)
      s.y = random(-height, height)
      s.z = random(width * 3)
  }

  private def drawStar(s: Star): Unit = {
    fill(255f)
    noStroke()
    val sx = map(s.x / s.z, 0, 1, 0, width)
    val sy = map(s.y / s.z, 0, 1, 0, height)
    val r = map(s.z, 0, width * 3, 5, 0)
    ellipse(sx, sy, r, r)
  }
}
