package br.com.treino.pokedexegsys.di

import br.com.treino.pokedexegsys.api.PokemonRepository
import br.com.treino.pokedexegsys.api.model.PokemonService
import br.com.treino.pokedexegsys.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonService): PokemonRepository{
        return PokemonRepository(api = api)
    }

}