import folium

location = [37.504430130745035, 127.02448732256488]

# tiles : 'Stamen Toner' 'Stamen Terrain' 'OpenStreetMap' ....
map_osm = folium.Map(location=location, zoom_start=13, tiles='Stamen Terrain')
map_osm.save('map_osm2.html')