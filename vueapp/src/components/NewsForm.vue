<template>
  <div class="layout-padding docs-input row justify-center">
    <div style="width: 500px; max-width: 90vw; text-align: left">
      <q-card>
        <q-card-title v-if="this.$route.params.id">Edit News Story</q-card-title>
        <q-card-title v-else>Create News Story</q-card-title>
        <q-card-main>
          <q-field>
            <q-input v-model="story.title" float-label="Title" />
          </q-field>
          <q-field>
            <q-input v-model="story.author.fullName" float-label="Author" />
          </q-field>
          <q-field>
            <q-datetime v-model="story.publishedDate" format="ddd, DD-MMM-YYYY hh:mm:ss A" type="datetime" float-label="Publish Date" />
          </q-field>
          <q-field>
            <q-input type="textarea" v-model="story.body" float-label="Details" :min-rows="4" />
          </q-field>
        </q-card-main>
        <q-card-separator />
        <q-card-actions>
          <q-btn flat color="secondary" @click="submit()">Submit</q-btn>
          <q-btn flat @click="cancel()">Cancel</q-btn>
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
  QIcon,
  date
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
    let data = {
      story: {
        title: '',
        body: '',
        publishedDate: new Date(),
        author: {
          fullName: ''
        }
      }
    }
    if (this.$route.params.id) {
      this.$http.get('/stories/' + this.$route.params.id)
        .then(resp => {
          data.story = resp.data
        })
    }
    return data
  },

  methods: {
    submit () {
      /* format publishedDate according to API format */
      this.story.publishedDate = date.formatDate(this.story.publishedDate, 'DD-MMM-YYYY hh:mm:ss a')
      this.$http.post('/stories', this.story)
        .then(resp => {
          this.$router.push({name: 'feeds'})
        })
    },

    edit (storyId) {
      this.$router.push({name: 'edit_news', params: {id: storyId}})
    },

    cancel () {
      this.$router.go(-1)
    }
  }
}
</script>

<style>
</style>
