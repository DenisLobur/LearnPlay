package models

case class Artist(name: String, country: String)

object Artist {

  val availableArtists = Seq(
    Artist("Wolfgang Amadeus Mozart", "Austria"),
    Artist("Ludwig van Beethoven", "Germany"),
    Artist("Johann Sebastian Bach", "Germany"),
    Artist("Frédéric François Chopin", "Poland"),
    Artist("Joseph Haydn", "Austria"),
    Artist("Antonio Lucio Vivaldi", "Italy"),
    Artist("Franz Peter Schubert", "Austria"),
    Artist("Franz Liszt", "Austria"),
    Artist("Giuseppe Fortunino Francesco Verdi", "Austria")
  )

  def fetch: Seq[Artist] = {
    availableArtists
  }

  def fetchByName(name: String) = {
    availableArtists.filter(_.name.contains(name))
  }

  def fetchByCountry(country: String) = {
    availableArtists.filter(_.country == country)
  }

  def fetchByNameOrCountry(name: String, country: String) = {
    availableArtists.filter(artist => artist.name.contains(name) ||
      artist.country == country)
  }
}
