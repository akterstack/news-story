<template>
  <div class="layout-padding docs-input row justify-center">
    <div style="width: 500px; max-width: 90vw; text-align: left">
      <q-card>
        <q-card-title>
          Create News Story
        </q-card-title>
        <q-card-main>
          <q-field>
            <q-input v-model="story.title" float-label="Title" :value="story.title" />
          </q-field>
          <q-field>
            <q-input type="textarea" v-model="story.body" float-label="Details" :value="story.body" />
          </q-field>
          <q-field>
            <q-input type="text" v-model="story.author.fullName" float-label="Author" :value="story.author.fullName" />
          </q-field>
        </q-card-main>
        <q-card-separator />
        <q-card-actions>
          <q-btn flat color="secondary" @click="submit()">Submit</q-btn>
        </q-card-actions>
      </q-card>
    </div>
  </div>
</template>

<script>
import {
  QCard,
  QCardTitle,
  QCardMain,
  QCardSeparator,
  QCardActions,
  QField,
  QToggle,
  QDatetime,
  QOptionGroup,
  QInput,
  QSelect,
  QChipsInput,
  QRating,
  QBtn,
  QIcon
} from 'quasar'

export default {
  components: {
    QCard,
    QCardTitle,
    QCardMain,
    QCardSeparator,
    QCardActions,
    QField,
    QToggle,
    QDatetime,
    QOptionGroup,
    QInput,
    QSelect,
    QChipsInput,
    QRating,
    QBtn,
    QIcon
  },

  data () {
    return {
      story: {
        author: {}
      }
    }
  },

  methods: {
    submit () {
      this.$http.post('/stories', this.story)
        .then(resp => {
          this.$router.push({name: 'news_detail', params: {id: resp.data.id}})
        })
    }
  }
}
</script>

<style>
</style>
